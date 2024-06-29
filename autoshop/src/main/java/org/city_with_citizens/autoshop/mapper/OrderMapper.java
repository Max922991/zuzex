package org.city_with_citizens.autoshop.mapper;

import org.city_with_citizens.dto.OrderDto;
import org.city_with_citizens.autoshop.entity.Car;
import org.city_with_citizens.autoshop.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "carId", target = "car", qualifiedByName = "toCar")
    Order toOrder(OrderDto orderDto);

    @Named("toCar")
    default Car toCar(UUID id) {
        Car car = new Car();
        car.setId(id);
        return car;
    }

}
