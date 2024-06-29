package org.city_with_citizens.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.dto.CarMarkDto;
import org.city_with_citizens.mapper.CarMarkMapper;
import org.city_with_citizens.service.CarMarkService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CarMarkController {

    private final CarMarkMapper carMarkMapper;
    private final CarMarkService carMarkService;

    @PostMapping("/model")
    public CarMarkDto create(@RequestBody CarMarkDto carMarkDto) {
        return carMarkMapper.toCarModelDto(
                carMarkService.create(
                        carMarkMapper.toCarModel(carMarkDto)
                )
        );
    }

}
