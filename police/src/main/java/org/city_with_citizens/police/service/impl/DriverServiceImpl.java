package org.city_with_citizens.police.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.city_with_citizens.police.client.SchoolClient;
import org.city_with_citizens.police.repository.DriverRepository;
import org.city_with_citizens.police.service.DriverService;
import org.city_with_citizens.police.service.LicenseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final LicenseService licenseService;
    private final SchoolClient schoolClient;

    @Override
    public Boolean confirmForAutoshop(UUID citizenId) {
        return checkActualLicense(citizenId) && checkingSchool(citizenId);
    }

    private Boolean checkActualLicense(UUID citizenId) {
        var optionalDriver = driverRepository.findDriverByCitizenId(citizenId);
        if (optionalDriver.isEmpty()) return false;

        var licenses = licenseService.getAllByDriverId(optionalDriver.get().getId());

        log.info(licenses.toString());

        var now = LocalDate.now();
        var isActualLicense = licenses.stream()
                .filter(license ->
                    license.getLicenseStart().isBefore(now) &&
                            license.getLicenseEnd().isAfter(now)
                )
                .findFirst();
        log.info(String.valueOf(isActualLicense.isPresent()));
        return isActualLicense.isPresent();
    }

    private Boolean checkingSchool(UUID citizenId) {
        try {
            var schoolResult = schoolClient.checkLicense(citizenId);
            log.info("Результат от школы: " + schoolResult);
            return schoolResult;
        } catch (Exception e) {
            return false;
        }
    }

}
