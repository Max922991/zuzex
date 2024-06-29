package org.city_with_citizens.pay_auto_coordinator.saga.pay_auto.steps;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.pay_auto_coordinator.client.AutoshopClient;
import org.city_with_citizens.pay_auto_coordinator.saga.SagaStep;
import org.city_with_citizens.dto.PayAutoDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ProvideCarStep implements SagaStep<PayAutoDto> {

    private final AutoshopClient autoshopClient;

    @Override
    public boolean action(PayAutoDto payAutoDto) {
        var autoshopResult = autoshopClient.provideCar(payAutoDto);
        return autoshopResult.getStatusCode() != HttpStatus.OK;
    }

    @Override
    public void compensate(PayAutoDto payAutoDto) {
        log.info(payAutoDto.toString());
        autoshopClient.provideCar(payAutoDto);
    }
}
