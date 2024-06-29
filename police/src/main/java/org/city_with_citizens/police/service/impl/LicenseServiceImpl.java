package org.city_with_citizens.police.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.police.entity.License;
import org.city_with_citizens.police.repository.LicenseRepository;
import org.city_with_citizens.police.service.LicenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;

    @Override
    public List<License> getAllByDriverId(UUID driverId) {
        return licenseRepository.findAllByDriverId(driverId);
    }
}
