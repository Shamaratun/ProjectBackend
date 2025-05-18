package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.dto.table.BookDTO;
import org.isdb.ProjectBackend.model.Author;
import org.isdb.ProjectBackend.model.Books;
import org.isdb.ProjectBackend.model.Warehouse;
import org.isdb.ProjectBackend.repository.AuthorRepository;
import org.isdb.ProjectBackend.repository.BookRepository;
import org.isdb.ProjectBackend.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private WarehouseRepository warehouseRepository;

	// Get all books
	@GetMapping
	public List<Books> getAllBooks() {
		return bookRepository.findAll();
	}

	// Get a single book by ID
	@GetMapping("/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable Long id) {
		Optional<Books> book = bookRepository.findById(id);
		return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Create a new book
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Books> createBook(@RequestBody BookDTO bookDTO) {
		Books book = new Books();

		book.setTitle(bookDTO.getTitle());
		book.setIsbn(bookDTO.getIsbn());

		book.setPrice(bookDTO.getPrice().doubleValue()); // Convert BigDecimal -> Double
		book.setRating(bookDTO.getRating().doubleValue()); // Convert BigDecimal -> Double

		book.setStock(bookDTO.getStock());
		book.setGenre(bookDTO.getGenre());

		Author author = authorRepository.findById(bookDTO.getAuthorId())
				.orElseThrow(() -> new RuntimeException("Author not found"));
		book.setAuthor(author);

		Warehouse warehouse = warehouseRepository.findById(bookDTO.getWarehouseId())
				.orElseThrow(() -> new RuntimeException("Warehouse not found"));
		book.setWarehouse(warehouse);
//		 Book book = new Book();
//		    book.setTitle(bookDto.getTitle());
//		    book.setAuthor(author);
//		    book.setWarehouse(warehouse);
//		    ...
		return ResponseEntity.ok(bookRepository.save(book));
	}

	// Update an existing book
	@PutMapping("/{id}")
	public ResponseEntity<Books> updateBook(@PathVariable Long id, @RequestBody Books updatedBook) {
		return bookRepository.findById(id).map(book -> {
			book.setTitle(updatedBook.getTitle());
			book.setAuthor(updatedBook.getAuthor());
			book.setIsbn(updatedBook.getIsbn());
			book.setPrice(updatedBook.getPrice());
			book.setStock(updatedBook.getStock());
			book.setImage(updatedBook.getImage());
			book.setGenre(updatedBook.getGenre());
			book.setRating(updatedBook.getRating());
			book.setCreatedAt(updatedBook.getCreatedAt());
			book.setUpdatedAt(updatedBook.getUpdatedAt());

			return ResponseEntity.ok(bookRepository.save(book));
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// Delete a book
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
