package org.city_with_citizens.police.repository;

import org.city_with_citizens.police.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LicenseRepository extends JpaRepository<License, UUID> {

    List<License> findAllByDriverId(UUID driverId);

}
