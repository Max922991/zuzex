package org.city_with_citizens.client;

import org.city_with_citizens.dto.FlatDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "houses", url = "${gateway}")
public interface HousesClient {

    @GetMapping(path = "/api/houses/flat/{flatId}")
    FlatDto getFlatById(@PathVariable UUID flatId);

}
