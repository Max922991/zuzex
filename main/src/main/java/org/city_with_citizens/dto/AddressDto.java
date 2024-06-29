package org.city_with_citizens.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AddressDto {

    private UUID id;
    private String city;
    private String street;
    private String houseNumber;

}
