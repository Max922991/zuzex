package org.city_with_citizens.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CarDto {

    private UUID id;
    private CarMarkDto carMarkDto;
    private String numberCar;
    private UUID citizenId;

}
