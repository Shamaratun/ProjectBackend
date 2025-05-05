package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.model.Author;
import org.isdb.ProjectBackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // Create or Update Author
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Get all authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Get author by ID
    public Optional<Author> getAuthorById(Integer id) {
        return authorRepository.findById(id);
    }

    // Delete author by ID
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }
}