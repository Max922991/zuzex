package org.city_with_citizens.pay_auto_coordinator.saga.pay_auto.steps;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.pay_auto_coordinator.client.BankClient;
import org.city_with_citizens.pay_auto_coordinator.saga.SagaStep;
import org.city_with_citizens.dto.DebitAccountDto;
import org.city_with_citizens.dto.PayAutoDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class DebitAccountStep implements SagaStep<PayAutoDto> {

    private final BankClient bankClient;

    @Override
    public boolean action(PayAutoDto payAutoDto) {
        log.info(payAutoDto.toString());
        var bankResult = bankClient.debitAccount(
                DebitAccountDto.builder()
                        .citizenId(payAutoDto.getCitizenId())
                        .amount(payAutoDto.getAmount())
                        .build());
        return bankResult.getStatusCode() == HttpStatus.OK;
    }

    @Override
    public void compensate(PayAutoDto payAutoDto) {
        var bankResult = bankClient.debitAccount(
                DebitAccountDto.builder()
                        .citizenId(payAutoDto.getCitizenId())
                        .amount(-payAutoDto.getAmount())
                        .build());
        bankResult.getStatusCode();
    }
}
