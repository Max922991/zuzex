package org.city_with_citizens.autoshop.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.autoshop.client.BankClient;
import org.city_with_citizens.autoshop.client.CitizensClient;
import org.city_with_citizens.autoshop.client.PayAutoCoordinatorClient;
import org.city_with_citizens.autoshop.client.PoliceClient;
import org.city_with_citizens.autoshop.entity.Order;
import org.city_with_citizens.autoshop.entity.StatusOrder;
import org.city_with_citizens.autoshop.entity.StatusOrderConfirm;
import org.city_with_citizens.dto.PayAutoDto;
import org.city_with_citizens.enums.StatusOrderConfirmType;
import org.city_with_citizens.enums.StatusOrderType;
import org.city_with_citizens.autoshop.repository.CarRepository;
import org.city_with_citizens.autoshop.repository.OrderRepository;
import org.city_with_citizens.autoshop.service.OrderService;
import org.city_with_citizens.autoshop.service.StatusOrderConfirmService;
import org.city_with_citizens.autoshop.service.StatusOrderService;
import org.city_with_citizens.dto.ConfirmBalanceBankDto;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CitizensClient citizensClient;
    private final BankClient bankClient;
    private final PoliceClient policeClient;
    private final StatusOrderConfirmService statusOrderConfirmService;
    private final StatusOrderService statusOrderService;
    private final CarRepository carRepository;
    private final PayAutoCoordinatorClient payAutoCoordinatorClient;

    private static Map<StatusOrderConfirmType, StatusOrderConfirm> statusConfirmMap;
    private static Map<StatusOrderType, StatusOrder> statusMap;

    @PostConstruct
    public void initStatusMap() {
        statusConfirmMap = statusOrderConfirmService.getStatusOrderConfirmTypes();
        statusMap = statusOrderService.getStatusOrderTypes();
    }

    @Override
    public Order newOrder(Order order) {
        if (order.getCar() == null) {
            throw new NoSuchElementException("Машины с указанным id не существует");
        }
        order.setPrice(getPrice(order));
        order.setStatusOrder(statusMap.get(StatusOrderType.NOT_COMPLETED));

        order.setBankStatusOrderConfirm(statusConfirmMap.get(StatusOrderConfirmType.IN_PROGRESS));
        order.setPoliceStatusOrderConfirm(statusConfirmMap.get(StatusOrderConfirmType.IN_PROGRESS));

        checkCorrect(order);

        orderRepository.save(order);

        getConfirms(order);
        return order;
    }

    @Override
    public String processingOrder(Order order) {
        var checkOrder = checkDuplicate(order);
        if (checkOrder.isPresent()) {
            return "Ваша заявка № " + checkOrder.get().getId() + " в работе: " +
                    "Подтверждение от банка: " + checkOrder.get().getBankStatusOrderConfirm().getType().name() +
                    "; " +
                    "Подтверждение от полиции: " + checkOrder.get().getPoliceStatusOrderConfirm().getType().name();
        }
        CompletableFuture.supplyAsync(() ->
                newOrder(order)
        );
        return "Ваша заявка на предзаказ отправлена в работу";
    }

    @Override
    public void purchase(Order order) {
        var persistedOrder = checkDuplicate(order).orElseThrow(() ->
                new NoSuchElementException("Данной заявки не существует"));
        persistedOrder.setStatusOrder(statusMap.get(StatusOrderType.COMPLETED));
        orderRepository.save(persistedOrder);

        payAutoCoordinatorClient.payAutoSaga(PayAutoDto.builder()
                .orderId(persistedOrder.getId())
                .carId(persistedOrder.getCar().getId())
                .amount(persistedOrder.getPrice())
                .citizenId(persistedOrder.getCitizenId())
                .build());
    }

    @Override
    public void updateStatus(UUID orderId, StatusOrderType statusOrderType) {
        var order = orderRepository.findById(orderId).orElseThrow(() ->
                new NoSuchElementException("Указанной заявки не существует")
        );
        order.setStatusOrder(statusMap.get(statusOrderType));
        orderRepository.save(order);
    }

    @Override
    public void provideCar(PayAutoDto payAutoDto) {
        log.info("Автомобиль " + payAutoDto.getCarId() + " отдан жителю " + payAutoDto.getCitizenId());
    }

    private Integer getPrice(Order order) {
        var car = carRepository.findById(order.getCar().getId()).orElseThrow(() ->
                new NoSuchElementException("Автомобиля с указанным id не существует!"));
        return car.getPrice();
    }

    private Optional<Order> checkDuplicate(Order order) {
        return orderRepository.
                findByCarIdAndCitizenId(
                        order.getCar().getId(),
                        order.getCitizenId());
    }

    private void getConfirms(Order order) {
        getConfirmOfBank(order);
        getConfirmOfPolice(order);
    }

    private void getConfirmOfBank(Order order) {
        var confirmBalanceBankDto = ConfirmBalanceBankDto.builder()
                .citizenId(order.getCitizenId())
                .priceCar(order.getPrice())
                .build();
        var confirmOfBankFuture = CompletableFuture.supplyAsync(() ->
                bankClient.enoughBalance(confirmBalanceBankDto));

        try {
            if (confirmOfBankFuture.get()) {
                order.setBankStatusOrderConfirm(statusConfirmMap.get(StatusOrderConfirmType.APPROVE));
            } else {
                order.setBankStatusOrderConfirm(statusConfirmMap.get(StatusOrderConfirmType.REJECTED));
            }
            orderRepository.save(order);
        } catch (Exception e) {
            log.warn("Не удалось получить подтверждение от банка");
            order.setBankStatusOrderConfirm(statusConfirmMap.get(StatusOrderConfirmType.NOT_CONFIRMED));
            orderRepository.save(order);
        }
    }

    private void getConfirmOfPolice(Order order) {
        var confirmOfPoliceFuture = CompletableFuture.supplyAsync(() ->
                policeClient.confirm_driver_licence(order.getCitizenId()));
        try {
            if (confirmOfPoliceFuture.get()) {
                order.setPoliceStatusOrderConfirm(statusConfirmMap.get(StatusOrderConfirmType.APPROVE));
            } else {
                order.setPoliceStatusOrderConfirm(statusConfirmMap.get(StatusOrderConfirmType.REJECTED));
            }
            orderRepository.save(order);
        } catch (Exception e) {
            log.warn("Не удалось получить подтверждение от полиции");
            order.setPoliceStatusOrderConfirm(statusConfirmMap.get(StatusOrderConfirmType.NOT_CONFIRMED));
            orderRepository.save(order);
        }
    }

    private void checkCorrect(Order order) {
        try {
            citizensClient.getById(order.getCitizenId());
        } catch (Exception e) {
            throw new NoSuchElementException("Жителя с указанным id не существует или не удалось в этом удостовериться");
        }
    }

}
