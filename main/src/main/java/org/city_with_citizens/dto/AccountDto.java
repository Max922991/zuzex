package org.city_with_citizens.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AccountDto {

    private UUID id;
    private Integer balance;
    private UUID citizenId;

}
