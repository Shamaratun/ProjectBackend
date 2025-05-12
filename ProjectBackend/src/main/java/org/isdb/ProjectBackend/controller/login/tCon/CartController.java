package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Cart;
import org.isdb.ProjectBackend.service.CartService;
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
@RequestMapping("/api/carts")
@CrossOrigin(origins = "http://localhost:4200") 
public class CartController {

	@Autowired
	private CartService cartService;

	
	@GetMapping
	public List<Cart> getAllCarts() {
		return cartService.getAllCarts();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
		Optional<Cart> cart = cartService.getCartById(id);
		return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	
	@PostMapping
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		Cart savedCart = cartService.saveCart(cart);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cartDetails) {
		Cart updatedCart = cartService.updateCart(id, cartDetails);
		return updatedCart != null ? ResponseEntity.ok(updatedCart)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
		cartService.deleteCart(id);
		return ResponseEntity.noContent().build();
	}
}
