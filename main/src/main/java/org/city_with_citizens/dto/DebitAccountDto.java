package org.city_with_citizens.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DebitAccountDto {

    private UUID citizenId;
    private Integer amount;

}
