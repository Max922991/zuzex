package org.city_with_citizens.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PayAutoDto {

    private UUID orderId;
    private UUID citizenId;
    private Integer amount;
    private UUID carId;

}
