package org.city_with_citizens.repository;

import org.city_with_citizens.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PassportRepository extends JpaRepository<Passport, UUID> {

    Passport findPassportByCitizenId(UUID citizenId);

}
