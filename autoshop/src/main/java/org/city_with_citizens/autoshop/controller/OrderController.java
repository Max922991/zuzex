package org.city_with_citizens.autoshop.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.dto.AnswerRequestOrderDto;
import org.city_with_citizens.dto.OrderDto;
import org.city_with_citizens.autoshop.mapper.OrderMapper;
import org.city_with_citizens.autoshop.service.OrderService;
import org.city_with_citizens.dto.PayAutoDto;
import org.city_with_citizens.enums.StatusOrderType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping("/order")
    public AnswerRequestOrderDto createOrder(@RequestBody OrderDto orderDto) {
        return AnswerRequestOrderDto.builder()
                .message(orderService.processingOrder(
                        orderMapper.toOrder(orderDto)
                ))
                .build();
    }


    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.OK)
    public void purchase(@RequestBody OrderDto orderDto) {
        var order = orderMapper.toOrder(orderDto);
        orderService.purchase(order);
    }

    @PostMapping("/approve_order_status")
    @ResponseStatus(HttpStatus.OK)
    public void approveStatusOrder(@RequestBody PayAutoDto payAutoDto) {
        orderService.updateStatus(payAutoDto.getOrderId(), StatusOrderType.COMPLETED);
    }

    @PostMapping("/recall_order_status")
    @ResponseStatus(HttpStatus.OK)
    public void recallStatusOrder(@RequestBody PayAutoDto payAutoDto) {
        orderService.updateStatus(payAutoDto.getOrderId(), StatusOrderType.NOT_COMPLETED);
    }

    @PostMapping("/provide_car")
    @ResponseStatus(HttpStatus.OK)
    public void provideCar(@RequestBody PayAutoDto payAutoDto) {
        orderService.provideCar(payAutoDto);
    }

}
