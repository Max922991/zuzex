package org.city_with_citizens.dto;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class CarMarkDto {

    private UUID id;
    private String mark;
    private String model;

}
