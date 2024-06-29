package org.city_with_citizens.bank.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.bank.entity.Account;
import org.city_with_citizens.bank.exception.AccountException;
import org.city_with_citizens.bank.repository.AccountRepository;
import org.city_with_citizens.bank.service.AccountService;
import org.city_with_citizens.dto.DebitAccountDto;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account create(UUID citizenId) {
        var account = Account.builder()
                .citizenId(citizenId)
                .balance(0)
                .build();
        return accountRepository.save(account);
    }

    @Override
    public void deleteByCitizenId(UUID citizenId) {
        var account = accountRepository.findAccountByCitizenId(citizenId).orElseThrow(()->
                new NoSuchElementException("У данного пользователя нет лицевого счета!"));
        if (account.getBalance() < 100) {
            accountRepository.delete(account);
        }
    }

    @Override
    public void debitAccount(DebitAccountDto debitAccountDto) {
        log.info("Списание средств!" + debitAccountDto.getCitizenId().toString());
        var account = accountRepository.findAccountByCitizenId(debitAccountDto.getCitizenId())
                .orElseThrow(() -> new NoSuchElementException("Данный пользователь не имеет лицевого счета"));
        var accountNewBalance = account.getBalance() - debitAccountDto.getAmount();
        if (accountNewBalance < 0) {
            throw new AccountException("Недостаточно средств для списания");
        }
        account.setBalance(accountNewBalance);
        accountRepository.save(account);
    }

    @Override
    public Boolean confirmBalance(UUID citizenId, Integer priceCar) {
        try {
            var account = accountRepository.findAccountByCitizenId(citizenId).orElseThrow(()->
                    new NoSuchElementException("У данного пользователя нет лицевого счета!"));
            return account.getBalance() >= priceCar;
        } catch (Exception e) {
            create(citizenId);
            return false;
        }
    }

}
