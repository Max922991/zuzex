package org.city_with_citizens.repository;

import org.city_with_citizens.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlatRepository extends JpaRepository<Flat, UUID> {}
