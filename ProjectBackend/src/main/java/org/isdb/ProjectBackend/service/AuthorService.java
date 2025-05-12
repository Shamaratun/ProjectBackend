package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Author;
import org.isdb.ProjectBackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

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

	public Author updateAuthor(Long id, Author newAuthorData) {
		return authorRepository.findById(id).map(author -> {
			author.setName(newAuthorData.getName());
			author.setBio(newAuthorData.getBio());
			author.setCountry(newAuthorData.getCountry());
			author.setDob(newAuthorData.getDob());
			return authorRepository.save(author);
		}).orElseThrow(() -> new EntityNotFoundException("Author not found"));
	}

	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}
}