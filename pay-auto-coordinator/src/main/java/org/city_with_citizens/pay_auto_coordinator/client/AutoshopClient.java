package org.city_with_citizens.pay_auto_coordinator.client;

import feign.FeignException;
import org.city_with_citizens.dto.PayAutoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "autoshop", url = "${gateway}")
public interface AutoshopClient {

    @PostMapping("/api/autoshop/approve_order_status")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5
    )
    ResponseEntity<?> approveStatus(@RequestBody PayAutoDto payAutoDto);

    @PostMapping("/api/autoshop/recall_order_status")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5
    )
    ResponseEntity<?> recallStatus(@RequestBody PayAutoDto payAutoDto);

    @PostMapping("/api/autoshop/provide_car")
    @Retryable(
            retryFor = {FeignException.class},
            maxAttempts = 5
    )
    ResponseEntity<?> provideCar(@RequestBody PayAutoDto payAutoDto);


}
