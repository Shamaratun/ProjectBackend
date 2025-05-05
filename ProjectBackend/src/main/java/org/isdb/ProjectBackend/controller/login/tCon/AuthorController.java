// package org.isdb.ProjectBackend.controller.login.tCon;

// import org.isdb.ProjectBackend.model.Author;
// import org.isdb.ProjectBackend.service.AuthorService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/authors")
// public class AuthorController {

//     @Autowired
//     private AuthorService authorService;

//     // Create or update an author
//     @PostMapping
//     public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
//         Author savedAuthor = authorService.saveAuthor(author);
//         return ResponseEntity.ok(savedAuthor);
//     }

//     // Get all authors
//     @GetMapping
//     public List<Author> getAllAuthors() {
//         return authorService.getAllAuthors();
//     }

//     // Get author by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
//         Optional<Author> author = authorService.getAuthorById(id);
//         return author.map(ResponseEntity::ok)
//                      .orElse(ResponseEntity.notFound().build());
//     }

//     // Update an author
//     @PutMapping("/{id}")
//     public ResponseEntity<Author> updateAuthor(@PathVariable Integer id, @RequestBody Author updatedAuthor) {
//         Optional<Author> existingAuthor = authorService.getAuthorById(id);
//         if (existingAuthor.isPresent()) {
//             updatedAuthor.setAuthorID(id); // Make sure the ID is set
//             return ResponseEntity.ok(authorService.saveAuthor(updatedAuthor));
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     // Delete author by ID
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteAuthor(@PathVariable Integer id) {
//         if (authorService.getAuthorById(id).isPresent()) {
//             authorService.deleteAuthor(id);
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }
