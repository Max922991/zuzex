package org.city_with_citizens.service;

import org.city_with_citizens.entity.Car;

import java.util.UUID;

public interface CarService {

    Car create(Car car);

    Car getById(UUID carId);

    Car update(Car car);

    void remove(UUID carId);

}
