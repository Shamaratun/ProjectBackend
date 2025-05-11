package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	// Additional query methods can go here (if needed)
}