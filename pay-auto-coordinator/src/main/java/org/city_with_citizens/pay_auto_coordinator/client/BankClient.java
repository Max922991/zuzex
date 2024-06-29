package org.city_with_citizens.pay_auto_coordinator.client;

import feign.FeignException;
import org.city_with_citizens.dto.DebitAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "bank", url = "${gateway}")
public interface BankClient {

    @PostMapping("/api/bank/debit_account")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 1100L)
    )
    ResponseEntity<?> debitAccount(@RequestBody DebitAccountDto debitAccountDto);

}