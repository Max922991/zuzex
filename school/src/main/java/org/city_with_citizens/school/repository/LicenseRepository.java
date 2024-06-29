package org.city_with_citizens.school.repository;

import org.city_with_citizens.school.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LicenseRepository extends JpaRepository<License, UUID> {

    Optional<License> findFirstByStudentId(UUID studentId);

}
