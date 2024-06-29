package org.city_with_citizens.autoshop.service;

import org.city_with_citizens.autoshop.entity.Car;

import java.util.UUID;

public interface CarService {

    Car create(Car car);

    Car getById(UUID carId);

    Car update(Car car);

    void delete(UUID carId);

}
