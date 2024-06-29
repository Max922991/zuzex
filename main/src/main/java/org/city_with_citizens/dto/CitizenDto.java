package org.city_with_citizens.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class CitizenDto {

    private UUID id;
    private String name;
    private GenderDto gender;
    private LocalDate birthday;

}