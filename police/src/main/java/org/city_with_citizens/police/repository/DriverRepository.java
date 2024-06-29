package org.city_with_citizens.police.repository;

import org.city_with_citizens.police.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {

    Optional<Driver> findDriverByCitizenId(UUID citizenId);

}
