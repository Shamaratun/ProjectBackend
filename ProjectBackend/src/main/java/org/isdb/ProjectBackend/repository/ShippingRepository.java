package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
    // You can add custom queries here if needed
}