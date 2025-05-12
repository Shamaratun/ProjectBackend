package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.CartItem;
import org.isdb.ProjectBackend.service.CartItemService;
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
@RequestMapping("/api/cart-items")
@CrossOrigin(origins = "http://localhost:4200") 
public class CartItemController {

	@Autowired
	private CartItemService cartItemService;

	// Get all cart items
	@GetMapping
	public List<CartItem> getAllCartItems() {
		return cartItemService.getAllCartItems();
	}

	// Get a cart item by ID
	@GetMapping("/{id}")
	public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
		Optional<CartItem> cartItem = cartItemService.getCartItemById(id);
		return cartItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// Create a new cart item
	@PostMapping
	public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
		CartItem savedCartItem = cartItemService.saveCartItem(cartItem);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCartItem);
	}

	// Update an existing cart item
	@PutMapping("/{id}")
	public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem cartItemDetails) {
		CartItem updatedCartItem = cartItemService.updateCartItem(id, cartItemDetails);
		return updatedCartItem != null ? ResponseEntity.ok(updatedCartItem)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// Delete a cart item
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
		cartItemService.deleteCartItem(id);
		return ResponseEntity.noContent().build();
	}
}
