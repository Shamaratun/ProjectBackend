package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    // Add custom query methods if needed
}