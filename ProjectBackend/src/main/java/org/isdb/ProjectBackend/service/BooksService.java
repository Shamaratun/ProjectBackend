package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Books;
import org.isdb.ProjectBackend.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	public Books saveBook(Books book) {
		return booksRepository.save(book);
	}

	public List<Books> getAllBooks() {
		return booksRepository.findAll();
	}

	public Optional<Books> getBookById(Integer id) {
		return booksRepository.findById(id);
	}

	public void deleteBook(Integer id) {
		booksRepository.deleteById(id);
	}
}