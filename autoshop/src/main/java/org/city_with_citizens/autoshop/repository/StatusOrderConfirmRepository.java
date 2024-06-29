package org.city_with_citizens.autoshop.repository;

import org.city_with_citizens.autoshop.entity.StatusOrderConfirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOrderConfirmRepository extends JpaRepository<StatusOrderConfirm, Short> {

}
