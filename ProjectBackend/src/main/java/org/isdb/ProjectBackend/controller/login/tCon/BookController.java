//package org.isdb.ProjectBackend.controller.login.tCon;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.isdb.ProjectBackend.model.Books;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/books")
//@CrossOrigin(origins = "*") // Allow requests from frontend
//public class BookController {
//
//	@Autowired
//	private BooksRepository bookRepository;
//
//	// Get all books
//	@GetMapping
//	public List<Books> getAllBooks() {
//		return booksRepository.findAll();
//	}
//
//	// Get a single book by ID
//	@GetMapping("/{id}")
//	public ResponseEntity<Books> getBookById(@PathVariable Integer id) {
//		Optional<Books> book = bookRepository.findById(id);
//		return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//	}
//
//	// Create a new book
//	@PostMapping
//	public Books createBook(@RequestBody Books book) {
//		return bookRepository.save(book);
//	}
//
//	// Update an existing book
//	@PutMapping("/{id}")
//	public ResponseEntity<Books> updateBook(@PathVariable Integer id, @RequestBody Books updatedBook) {
//		return bookRepository.findById(id).map(book -> {
//			book.setTitle(updatedBook.getTitle());
//			book.setIsbn(updatedBook.getIsbn());
//			book.setPrice(updatedBook.getPrice());
//			book.setStock(updatedBook.getStock());
//			book.setImage(updatedBook.getImage());
//			book.setGenre(updatedBook.getGenre());
//			book.setRating(updatedBook.getRating());
//			book.setCreatedAt(updatedBook.getCreatedAt());
//			book.setUpdatedAt(updatedBook.getUpdatedAt());
//			book.setAuthor(updatedBook.getAuthor());
//			return ResponseEntity.ok(bookRepository.save(book));
//		}).orElseGet(() -> ResponseEntity.notFound().build());
//	}
//
//	// Delete a book
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
//		if (bookRepository.existsById(id)) {
//			bookRepository.deleteById(id);
//			return ResponseEntity.noContent().build();
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//}