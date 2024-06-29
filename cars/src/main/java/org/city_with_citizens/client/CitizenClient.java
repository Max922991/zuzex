package org.city_with_citizens.client;

import org.city_with_citizens.dto.CitizenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "citizens", url = "${gateway}")
public interface CitizenClient {

    @GetMapping("/api/citizens/citizen/{citizenId}")
    CitizenDto getCitizenById(@PathVariable UUID citizenId);

}
