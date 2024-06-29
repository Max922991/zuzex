package org.city_with_citizens.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ConfirmBalanceBankDto {

    private UUID citizenId;
    private Integer priceCar;

}
