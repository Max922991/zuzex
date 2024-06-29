package org.city_with_citizens.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.dto.CarDto;
import org.city_with_citizens.mapper.CarMapper;
import org.city_with_citizens.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class CarController {

    private final CarMapper carMapper;
    private final CarService carService;

    @PostMapping
    public CarDto create(@RequestBody CarDto carDto) {
        System.out.println(carDto);
        return carMapper.toCarDto(
                carService.create(
                        carMapper.toCar(carDto)
                )
        );
    }

    @GetMapping("/car/{carId}")
    public CarDto getById(@PathVariable UUID carId) {
        return carMapper.toCarDto(
                carService.getById(carId)
        );
    }

    @PutMapping
    public CarDto update(@RequestBody CarDto carDto) {
        return carMapper.toCarDto(
                carService.update(
                        carMapper.toCar(carDto)
                )
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{carId}")
    public void delete(@PathVariable UUID carId) {
        carService.remove(carId);
    }

}
