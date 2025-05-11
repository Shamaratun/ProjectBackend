package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Author;
import org.isdb.ProjectBackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public Optional<Author> getAuthorById(Long id) {
		return authorRepository.findById(id);
	}

	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

	public Author updateAuthor(Long id, Author updatedAuthor) {
		// Optional: You may want to check if the author exists
		updatedAuthor.setAuthorId(id);
		return authorRepository.save(updatedAuthor);
	}

	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}
}
