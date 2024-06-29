package org.city_with_citizens.autoshop.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.autoshop.entity.Car;
import org.city_with_citizens.autoshop.repository.CarRepository;
import org.city_with_citizens.autoshop.service.CarService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(UUID carId) {
        return carRepository.findById(carId).orElseThrow(()
                -> new NoSuchElementException(("Машины с указанным id не существует")));
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void delete(UUID carId) {
        carRepository.deleteById(carId);
    }
}
