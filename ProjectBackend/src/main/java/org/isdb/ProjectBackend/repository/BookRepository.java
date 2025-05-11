package org.isdb.ProjectBackend.repository;

import org.isdb.ProjectBackend.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
	// Custom queries can go here
}
