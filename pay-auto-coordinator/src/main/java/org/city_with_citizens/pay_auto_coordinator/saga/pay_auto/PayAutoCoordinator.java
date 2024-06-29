package org.city_with_citizens.pay_auto_coordinator.saga.pay_auto;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.pay_auto_coordinator.saga.SagaStep;
import org.city_with_citizens.pay_auto_coordinator.saga.pay_auto.steps.DebitAccountStep;
import org.city_with_citizens.pay_auto_coordinator.saga.pay_auto.steps.ProvideCarStep;
import org.city_with_citizens.pay_auto_coordinator.saga.pay_auto.steps.UpdateStatusCarStep;
import org.city_with_citizens.dto.PayAutoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class PayAutoCoordinator {

    private List<SagaStep<PayAutoDto>> steps;

    private final DebitAccountStep debitAccountStep;
    private final UpdateStatusCarStep updateStatusCarStep;
    private final ProvideCarStep provideCarStep;

    @PostConstruct
    private void init() {
        steps.add(debitAccountStep);
        steps.add(updateStatusCarStep);
        steps.add(provideCarStep);
    }

    public void start(PayAutoDto payAutoDto) {
        log.info(payAutoDto.toString());
        for (int i = 0; i < steps.size(); i++) {
            var step = steps.get(i);
            if (!step.action(payAutoDto)) {
                for (int j = i; j >= 0; j--) {
                    step.compensate(payAutoDto);
                }
            }
        }
    }

}
