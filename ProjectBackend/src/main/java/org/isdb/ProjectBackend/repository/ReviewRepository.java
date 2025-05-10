package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	// You can add custom query methods here if needed
}