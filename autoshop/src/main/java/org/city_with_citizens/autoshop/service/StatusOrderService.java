package org.city_with_citizens.autoshop.service;

import org.city_with_citizens.autoshop.entity.StatusOrder;
import org.city_with_citizens.enums.StatusOrderType;

import java.util.Map;

public interface StatusOrderService {

    Map<StatusOrderType, StatusOrder> getStatusOrderTypes();

}
