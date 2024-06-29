package org.city_with_citizens.autoshop.client;

import feign.FeignException;
import org.city_with_citizens.dto.ConfirmBalanceBankDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "bank", url = "${gateway}")
public interface BankClient {

    @PostMapping("/api/bank/confirm_balance")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 1100L)
    )
    Boolean enoughBalance(@RequestBody ConfirmBalanceBankDto confirmBalanceBankDto);

}
