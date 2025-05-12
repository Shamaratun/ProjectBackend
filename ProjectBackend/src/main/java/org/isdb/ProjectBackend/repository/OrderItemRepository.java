package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	// You can add custom query methods here if needed
}
