package org.city_with_citizens.client;

import org.city_with_citizens.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(value = "bank", url = "${gateway}")
public interface BankClient {

    @PostMapping("/api/bank/account")
    AccountDto create(@RequestBody UUID citizenId);

    @DeleteMapping("/api/bank/account/{citizenId}")
    void delete(@PathVariable UUID citizenId);

}
