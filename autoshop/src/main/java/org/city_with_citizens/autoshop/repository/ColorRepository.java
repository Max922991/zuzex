package org.city_with_citizens.autoshop.repository;

import org.city_with_citizens.autoshop.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColorRepository extends JpaRepository<Color, UUID> {
}
