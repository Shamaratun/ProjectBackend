package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.CartItem;
import org.isdb.ProjectBackend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	// Get all cart items
	public List<CartItem> getAllCartItems() {
		return cartItemRepository.findAll();
	}

	// Get a cart item by ID
	public Optional<CartItem> getCartItemById(Integer id) {
		return cartItemRepository.findById(id);
	}

	// Save a new cart item
	public CartItem saveCartItem(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	// Update an existing cart item
	public CartItem updateCartItem(Integer id, CartItem cartItemDetails) {
		Optional<CartItem> existingCartItem = cartItemRepository.findById(id);
		if (existingCartItem.isPresent()) {
			CartItem updatedCartItem = existingCartItem.get();
			updatedCartItem.setQuantity(cartItemDetails.getQuantity());
			updatedCartItem.setCart(cartItemDetails.getCart());
			updatedCartItem.setBook(cartItemDetails.getBook());
			return cartItemRepository.save(updatedCartItem);
		}
		return null; // Handle case where cart item does not exist
	}

	// Delete a cart item by ID
	public void deleteCartItem(Integer id) {
		cartItemRepository.deleteById(id);
	}
}
