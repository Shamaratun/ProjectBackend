package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // You can add custom queries if needed
}