package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.WishlistItem;
import org.isdb.ProjectBackend.service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/wishlist-items")
@CrossOrigin(origins = "http://localhost:4200") 
public class WishlistItemController {

	@Autowired
	private WishlistItemService wishlistItemService;

	// Get all wishlist items
	@GetMapping
	public List<WishlistItem> getAllWishlistItems() {
		return wishlistItemService.getAllWishlistItems();
	}

	// Get a wishlist item by ID
	@GetMapping("/{id}")
	public ResponseEntity<WishlistItem> getWishlistItemById(@PathVariable Integer id) {
		Optional<WishlistItem> wishlistItem = wishlistItemService.getWishlistItemById(id);
		return wishlistItem.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// Create a new wishlist item
	@PostMapping
	public ResponseEntity<WishlistItem> createWishlistItem(@RequestBody WishlistItem wishlistItem) {
		WishlistItem savedWishlistItem = wishlistItemService.saveWishlistItem(wishlistItem);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedWishlistItem);
	}

	// Update an existing wishlist item
	@PutMapping("/{id}")
	public ResponseEntity<WishlistItem> updateWishlistItem(@PathVariable Integer id,
			@RequestBody WishlistItem wishlistItemDetails) {
		WishlistItem updatedWishlistItem = wishlistItemService.updateWishlistItem(id, wishlistItemDetails);
		return updatedWishlistItem != null ? ResponseEntity.ok(updatedWishlistItem)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// Delete a wishlist item
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWishlistItem(@PathVariable Integer id) {
		wishlistItemService.deleteWishlistItem(id);
		return ResponseEntity.noContent().build();
	}
}
