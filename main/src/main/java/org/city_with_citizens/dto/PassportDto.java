package org.city_with_citizens.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PassportDto {

    private UUID id;
    private UUID citizenId;
    private UUID addressFlatId;
    private String number;
    private String series;

}
