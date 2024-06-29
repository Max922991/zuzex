package org.city_with_citizens.autoshop.service;

import org.city_with_citizens.autoshop.entity.StatusOrderConfirm;
import org.city_with_citizens.enums.StatusOrderConfirmType;

import java.util.Map;

public interface StatusOrderConfirmService {

    Map<StatusOrderConfirmType, StatusOrderConfirm> getStatusOrderConfirmTypes();

}
