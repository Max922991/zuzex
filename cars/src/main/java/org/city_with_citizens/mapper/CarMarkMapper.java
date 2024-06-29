package org.city_with_citizens.mapper;

import org.city_with_citizens.dto.CarMarkDto;
import org.city_with_citizens.entity.CarMark;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMarkMapper {

    CarMark toCarModel(CarMarkDto carMarkDto);

    CarMarkDto toCarModelDto(CarMark carMark);

}
