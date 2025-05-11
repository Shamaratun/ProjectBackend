package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;

import org.isdb.ProjectBackend.model.Books;
import org.isdb.ProjectBackend.service.BookService;
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
	private BookService bookService;

	@GetMapping
	public List<Books> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable Long id) {
		return bookService.getBookById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Books> createBook(@RequestBody Books book) {
		return ResponseEntity.ok(bookService.createBook(book));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Books> updateBook(@PathVariable Long id, @RequestBody Books updatedBook) {
		return ResponseEntity.ok(bookService.updateBook(id, updatedBook));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
}