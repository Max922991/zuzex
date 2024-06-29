package org.city_with_citizens.school.service.impl;

import lombok.AllArgsConstructor;
import org.city_with_citizens.school.repository.LicenseRepository;
import org.city_with_citizens.school.repository.StudentRepository;
import org.city_with_citizens.school.service.LicenseService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class LicenseServiceImpl implements LicenseService {

    private final StudentRepository studentRepository;
    private final LicenseRepository licenseRepository;

    @Override
    public Boolean checkLicense(UUID citizenId) {
        var student = studentRepository.findStudentByCitizenId(citizenId);
        if(student.isEmpty()) return false;

        var license = licenseRepository.findFirstByStudentId(student.get().getId());

        return license.isPresent();
    }
}
