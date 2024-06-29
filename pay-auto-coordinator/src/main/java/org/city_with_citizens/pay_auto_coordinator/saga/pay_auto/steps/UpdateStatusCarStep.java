package org.city_with_citizens.pay_auto_coordinator.saga.pay_auto.steps;

import lombok.AllArgsConstructor;
import org.city_with_citizens.pay_auto_coordinator.client.AutoshopClient;
import org.city_with_citizens.pay_auto_coordinator.saga.SagaStep;
import org.city_with_citizens.dto.PayAutoDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateStatusCarStep implements SagaStep<PayAutoDto> {

    private final AutoshopClient autoshopClient;

    @Override
    public boolean action(PayAutoDto payAutoDto) {
        var autoshopResult = autoshopClient.approveStatus(payAutoDto);
        return autoshopResult.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public void compensate(PayAutoDto payAutoDto) {
        var autoshopResult = autoshopClient.recallStatus(payAutoDto);
        autoshopResult.getStatusCode();
    }
}
