package org.city_with_citizens.mapper;

import org.city_with_citizens.dto.CarDto;
import org.city_with_citizens.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CarMarkMapper.class})
public interface CarMapper {

    Car toCar(CarDto carDto);

    CarDto toCarDto(Car car);

}
