package org.city_with_citizens.school.service;

import java.util.UUID;

public interface LicenseService {

    Boolean checkLicense(UUID citizenId);

}
