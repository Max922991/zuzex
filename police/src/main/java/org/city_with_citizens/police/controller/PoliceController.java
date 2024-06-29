package org.city_with_citizens.police.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.police.service.DriverService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class PoliceController {

    private final DriverService driverService;

    @PostMapping("/confirm_driver_license")
    Boolean confirm_driver_licence(@RequestBody UUID citizenId) {
        return driverService.confirmForAutoshop(citizenId);
    }

}
