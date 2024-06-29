package org.city_with_citizens.autoshop.repository;

import org.city_with_citizens.autoshop.entity.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusOrderRepository extends JpaRepository<StatusOrder, Short> {
}
