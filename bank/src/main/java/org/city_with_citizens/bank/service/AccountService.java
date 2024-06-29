package org.city_with_citizens.bank.service;

import org.city_with_citizens.bank.entity.Account;
import org.city_with_citizens.dto.DebitAccountDto;

import java.util.UUID;

public interface AccountService {

    Account create(UUID citizenId);

    Boolean confirmBalance(UUID citizenId, Integer priceCar);

    void deleteByCitizenId(UUID citizenId);

    void debitAccount(DebitAccountDto debitAccountDto);

}
