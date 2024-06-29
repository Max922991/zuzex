package org.city_with_citizens.autoshop.service;

import org.city_with_citizens.autoshop.entity.Order;
import org.city_with_citizens.dto.PayAutoDto;
import org.city_with_citizens.enums.StatusOrderType;

import java.util.UUID;

public interface OrderService {

    Order newOrder(Order order);

    String processingOrder(Order order);

    void purchase(Order order);

    void updateStatus(UUID orderId, StatusOrderType statusOrderType);

    void provideCar(PayAutoDto payAutoDto);
}
