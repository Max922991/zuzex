package org.city_with_citizens.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderDto {

    private UUID id;
    private UUID citizenId;
    private UUID carId;

}
