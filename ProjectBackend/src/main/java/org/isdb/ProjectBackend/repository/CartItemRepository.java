package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    // You can add custom query methods here if needed
}
