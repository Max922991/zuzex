package org.city_with_citizens.pay_auto_coordinator.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.pay_auto_coordinator.saga.pay_auto.PayAutoCoordinator;
import org.city_with_citizens.dto.PayAutoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class PayAutoSagaController {

    private final PayAutoCoordinator payAutoCoordinator;

    @PostMapping("/pay_auto_saga")
    public void payAutoSaga(@RequestBody PayAutoDto payAutoDto) {
        log.info(payAutoDto.toString());
        payAutoCoordinator.start(payAutoDto);
    }

}