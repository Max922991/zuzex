package org.city_with_citizens.school.controller;

import lombok.AllArgsConstructor;
import org.city_with_citizens.school.service.LicenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class SchoolController {

    private final LicenseService licenseService;

    @GetMapping("/check_license/{citizenId}")
    public Boolean checkLicense(@PathVariable UUID citizenId) {
        return licenseService.checkLicense(citizenId);
    }

}
