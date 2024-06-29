package org.city_with_citizens.autoshop.client;

import feign.FeignException;
import org.city_with_citizens.dto.PayAutoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "coordinator", url = "${gateway}")
public interface PayAutoCoordinatorClient {

    @PostMapping("/api/pay_auto_coordinator/pay_auto_saga")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5)
    void payAutoSaga(@RequestBody PayAutoDto payAutoDto);

}
