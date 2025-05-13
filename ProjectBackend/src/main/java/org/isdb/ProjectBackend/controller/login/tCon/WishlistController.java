package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Wishlist;
import org.isdb.ProjectBackend.service.WishlistService;
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
@RequestMapping("/api/wishlists")
@CrossOrigin(origins = "http://localhost:4200")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	// Create a new wishlist
	@PostMapping
	public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist) {
		Wishlist createdWishlist = wishlistService.saveWishlist(wishlist);
		return ResponseEntity.ok(createdWishlist);
	}

	// Get all wishlists
	@GetMapping
	public ResponseEntity<List<Wishlist>> getAllWishlists() {
		List<Wishlist> wishlists = wishlistService.getAllWishlists();
		return ResponseEntity.ok(wishlists);
	}

	// Get a wishlist by ID
	@GetMapping("/{id}")
	public ResponseEntity<Wishlist> getWishlistById(@PathVariable Long id) {
		Optional<Wishlist> wishlist = wishlistService.getWishlistById(id);
		return wishlist.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Update an existing wishlist
	@PutMapping("/{id}")
	public ResponseEntity<Wishlist> updateWishlist(@PathVariable Long id, @RequestBody Wishlist updatedWishlist) {
		Optional<Wishlist> existing = wishlistService.getWishlistById(id);
		if (existing.isPresent()) {
			updatedWishlist.setWishlistId(id);
			Wishlist savedWishlist = wishlistService.saveWishlist(updatedWishlist);
			return ResponseEntity.ok(savedWishlist);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete a wishlist by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWishlist(@PathVariable Long id) {
		if (wishlistService.getWishlistById(id).isPresent()) {
			wishlistService.deleteWishlist(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
