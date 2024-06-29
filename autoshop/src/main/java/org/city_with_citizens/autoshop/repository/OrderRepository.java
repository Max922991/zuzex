package org.city_with_citizens.autoshop.repository;

import org.city_with_citizens.autoshop.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @EntityGraph(attributePaths = {"car"})
    Optional<Order> findByCarIdAndCitizenId(UUID carId, UUID citizenId);

}
