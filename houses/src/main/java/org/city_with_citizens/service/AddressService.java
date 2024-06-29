package org.city_with_citizens.service;

import org.city_with_citizens.entity.Address;

import java.util.UUID;

public interface AddressService {

    Address create(Address house);

    Address getById(UUID houseId);

    Address update(Address house);

    void delete(UUID houseId);

}
