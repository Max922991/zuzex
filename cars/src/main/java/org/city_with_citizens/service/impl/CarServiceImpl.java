package org.city_with_citizens.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.entity.Car;
import org.city_with_citizens.client.CitizenClient;
import org.city_with_citizens.exception.CarCreateException;
import org.city_with_citizens.repository.CarRepository;
import org.city_with_citizens.service.CarService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CitizenClient citizenClient;

    @Override
    public Car create(Car car) {
        isCorrect(car);
        return carRepository.save(car);
    }

    @Override
    public Car getById(UUID carId) {
        return carRepository.findById(carId).orElseThrow(() ->
                new NoSuchElementException("Машины с указанным id не существует")
        );
    }

    @Override
    public Car update(Car car) {
        isCorrect(car);
        return carRepository.save(car);
    }

    @Override
    public void remove(UUID carId) {
        carRepository.deleteById(carId);
    }

    private void isCorrect(Car car) {
        if (car.getCarMark() == null) {
            throw new CarCreateException("Машина не может быть без модели");
        }
        if (car.getCitizenId() != null) {
            try {
                citizenClient.getCitizenById(car.getCitizenId());
            } catch (Exception e) {
                throw new NoSuchElementException("Указанного жителя не существует или не удалось удостовериться в еге существовании");
            }
        }
    }

}
