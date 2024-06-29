package org.city_with_citizens.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class FlatDto {

    private UUID id;
    private String flatNumber;
    private AddressDto addressDto;

}
