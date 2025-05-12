package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {
    // You can add custom query methods here if needed
}
