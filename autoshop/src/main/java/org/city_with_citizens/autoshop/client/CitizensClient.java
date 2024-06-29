package org.city_with_citizens.autoshop.client;

import feign.FeignException;
import org.city_with_citizens.dto.CarDto;
import org.city_with_citizens.dto.CitizenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "citizens", url = "${gateway}")
public interface CitizensClient {

    @GetMapping("/api/citizens/citizen/{citizenId}")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 1100L)
    )
    CitizenDto getById(@PathVariable UUID citizenId);

    @PostMapping("/api/citizens/provide_car")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 1100L)
    )
    boolean sendCar(@RequestBody CarDto carDto);

}
