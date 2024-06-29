package org.city_with_citizens.police;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableFeignClients
@EnableRetry
public class PoliceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoliceApplication.class, args);
    }
}
