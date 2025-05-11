package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Books;
import org.isdb.ProjectBackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Books> getAllBooks() {
		return bookRepository.findAll();
	}

	public Optional<Books> getBookById(Long id) {
		return bookRepository.findById(id);
	}

	public Books createBook(Books book) {
		return bookRepository.save(book);
	}

	public Books updateBook(Long id, Books updatedBook) {
		return bookRepository.findById(id).map(book -> {
			book.setTitle(updatedBook.getTitle());
			book.setAuthor(updatedBook.getAuthor());
			book.setGenre(updatedBook.getGenre());
			book.setIsbn(updatedBook.getIsbn());
			book.setPrice(updatedBook.getPrice());
			book.setStock(updatedBook.getStock());
			book.setImage(updatedBook.getImage());
			book.setRating(updatedBook.getRating());
			book.setUpdatedAt(updatedBook.getUpdatedAt());
			return bookRepository.save(book);
		}).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
	}

	public void deleteBook(Long id) {
		if (!bookRepository.existsById(id)) {
			throw new RuntimeException("Book not found with id: " + id);
		}
		bookRepository.deleteById(id);
	}
}