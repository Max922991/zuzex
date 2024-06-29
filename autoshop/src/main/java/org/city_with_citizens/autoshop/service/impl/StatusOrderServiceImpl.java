package org.city_with_citizens.autoshop.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.autoshop.entity.StatusOrder;
import org.city_with_citizens.enums.StatusOrderType;
import org.city_with_citizens.autoshop.repository.StatusOrderRepository;
import org.city_with_citizens.autoshop.service.StatusOrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class StatusOrderServiceImpl implements StatusOrderService {

    private StatusOrderRepository statusOrderRepository;

    @Override
    public Map<StatusOrderType, StatusOrder> getStatusOrderTypes() {
        var statusOrders = statusOrderRepository.findAll();
        Map<StatusOrderType, StatusOrder> map = new HashMap<>();
        for(StatusOrderType type : StatusOrderType.values()) {
            map.put(type, statusOrders.stream()
                    .filter(statusOrder ->
                            statusOrder.getType() == type
                    )
                    .findFirst()
                    .orElse(null)
            );
        }
        return map;
    }
}
