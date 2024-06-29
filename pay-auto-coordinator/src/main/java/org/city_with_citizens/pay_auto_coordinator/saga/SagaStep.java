package org.city_with_citizens.pay_auto_coordinator.saga;

public interface SagaStep<T> {

    boolean action(T dto);

    void compensate(T dto);

}
