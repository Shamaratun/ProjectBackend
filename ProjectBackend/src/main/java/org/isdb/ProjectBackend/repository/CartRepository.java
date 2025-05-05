package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	// You can add custom query methods here if needed
}
