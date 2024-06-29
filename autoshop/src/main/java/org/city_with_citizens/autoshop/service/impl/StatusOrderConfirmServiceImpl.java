package org.city_with_citizens.autoshop.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.autoshop.entity.StatusOrderConfirm;
import org.city_with_citizens.enums.StatusOrderConfirmType;
import org.city_with_citizens.autoshop.repository.StatusOrderConfirmRepository;
import org.city_with_citizens.autoshop.service.StatusOrderConfirmService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class StatusOrderConfirmServiceImpl implements StatusOrderConfirmService {

    private final StatusOrderConfirmRepository statusOrderConfirmRepository;

    public Map<StatusOrderConfirmType, StatusOrderConfirm> getStatusOrderConfirmTypes() {
        var statusOrders = statusOrderConfirmRepository.findAll();
        Map<StatusOrderConfirmType, StatusOrderConfirm> map = new HashMap<>();
        for(StatusOrderConfirmType type : StatusOrderConfirmType.values()) {
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
