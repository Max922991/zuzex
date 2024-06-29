package org.city_with_citizens.bank.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.bank.mapper.AccountMapper;
import org.city_with_citizens.bank.service.AccountService;
import org.city_with_citizens.dto.AccountDto;
import org.city_with_citizens.dto.ConfirmBalanceBankDto;
import org.city_with_citizens.dto.DebitAccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping("/confirm_balance")
    public Boolean confirmBalance(@RequestBody ConfirmBalanceBankDto confirmBalanceBankDto) {
        return accountService.confirmBalance(
                confirmBalanceBankDto.getCitizenId(), confirmBalanceBankDto.getPriceCar()
        );
    }

    @PostMapping("/account")
    public AccountDto confirmBalance(@RequestBody UUID citizenId) {
        return accountMapper.toAccountDto(accountService.create(citizenId));
    }

    @PostMapping("/debit_account")
    @ResponseStatus(HttpStatus.OK)
    public void debitAccount(@RequestBody DebitAccountDto debitAccountDto) {
        accountService.debitAccount(debitAccountDto);
    }

    @DeleteMapping("/account/{citizenId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID citizenId) {
        accountService.deleteByCitizenId(citizenId);
    }

}
