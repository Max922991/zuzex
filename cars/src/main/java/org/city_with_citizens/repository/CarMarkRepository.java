package org.city_with_citizens.repository;

import org.city_with_citizens.entity.CarMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarMarkRepository extends JpaRepository<CarMark, UUID> {}
