package org.city_with_citizens.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.entity.CarMark;
import org.city_with_citizens.repository.CarMarkRepository;
import org.city_with_citizens.service.CarMarkService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarMarkServiceImpl implements CarMarkService {

    private final CarMarkRepository carMarkRepository;

    @Override
    public CarMark create(CarMark carMark) {
        return carMarkRepository.save(carMark);
    }
}
