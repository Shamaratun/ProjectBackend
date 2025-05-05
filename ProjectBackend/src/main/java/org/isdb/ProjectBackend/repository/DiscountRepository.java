package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
    // You can add custom query methods here if needed
}