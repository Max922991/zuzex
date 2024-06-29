package org.city_with_citizens.autoshop.client;

import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(value = "police", url = "${gateway}")
public interface PoliceClient {

    @PostMapping("/api/police/confirm_driver_license")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 1100L)
    )
    Boolean confirm_driver_licence(@RequestBody UUID citizenId);

}