package org.city_with_citizens.pay_auto_coordinator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableFeignClients
@EnableRetry
public class PayAutoCoordinatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayAutoCoordinatorApplication.class);
    }
}
