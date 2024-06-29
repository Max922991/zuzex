package org.city_with_citizens.bank.mapper;

import org.city_with_citizens.dto.AccountDto;
import org.city_with_citizens.bank.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto toAccountDto(Account account);

}
