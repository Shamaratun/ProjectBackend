package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.WishlistItem;
import org.isdb.ProjectBackend.repository.WishlistItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistItemService {

	@Autowired
	private WishlistItemRepository wishlistItemRepository;

	// Get all wishlist items
	public List<WishlistItem> getAllWishlistItems() {
		return wishlistItemRepository.findAll();
	}

	// Get a wishlist item by ID
	public Optional<WishlistItem> getWishlistItemById(Integer id) {
		return wishlistItemRepository.findById(id);
	}

	// Save a new wishlist item
	public WishlistItem saveWishlistItem(WishlistItem wishlistItem) {
		return wishlistItemRepository.save(wishlistItem);
	}

	// Update an existing wishlist item
	public WishlistItem updateWishlistItem(Integer id, WishlistItem wishlistItemDetails) {
		Optional<WishlistItem> existingWishlistItem = wishlistItemRepository.findById(id);
		if (existingWishlistItem.isPresent()) {
			WishlistItem updatedWishlistItem = existingWishlistItem.get();
			// updatedWishlistItem.setWishlist(wishlistItemDetails.getWishlist());
			// updatedWishlistItem.setBook(wishlistItemDetails.getBook());
			return wishlistItemRepository.save(updatedWishlistItem);
		}
		return null; // Handle case where wishlist item does not exist
	}

	// Delete a wishlist item by ID
	public void deleteWishlistItem(Integer id) {
		wishlistItemRepository.deleteById(id);
	}
}