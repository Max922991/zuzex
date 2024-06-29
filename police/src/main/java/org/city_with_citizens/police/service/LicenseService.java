package org.city_with_citizens.police.service;

import org.city_with_citizens.police.entity.License;

import java.util.List;
import java.util.UUID;

public interface LicenseService {

    List<License> getAllByDriverId(UUID driverId);

}
