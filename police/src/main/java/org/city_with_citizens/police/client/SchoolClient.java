package org.city_with_citizens.police.client;

import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "school", url = "${gateway}")
public interface SchoolClient {

    @GetMapping("/api/school/check_license/{citizenId}")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 1100L)
    )
    Boolean checkLicense(@PathVariable UUID citizenId);

}
