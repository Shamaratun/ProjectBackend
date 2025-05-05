package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	// You can add custom query methods here if needed
}