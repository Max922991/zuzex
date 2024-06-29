package org.city_with_citizens.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.entity.Address;
import org.city_with_citizens.repository.AddressRepository;
import org.city_with_citizens.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository houseRepository;

    @Override
    public Address create(Address house) {
        return houseRepository.save(house);
    }

    @Override
    public Address getById(UUID houseId) {
        return houseRepository.findById(houseId).orElseThrow(()->
                new NoSuchElementException("Дом с указанным id не существует"));
    }

    @Override
    public Address update(Address house) {
        return houseRepository.save(house);
    }

    @Override
    public void delete(UUID houseId) {
        houseRepository.deleteById(houseId);
    }
}
