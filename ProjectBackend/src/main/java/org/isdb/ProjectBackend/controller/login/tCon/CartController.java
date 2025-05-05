package org.isdb.ProjectBackend.controller.login.tCon;

import org.isdb.ProjectBackend.model.Cart;
import org.isdb.ProjectBackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    // Get all carts
    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    // Get a cart by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Integer id) {
        Optional<Cart> cart = cartService.getCartById(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new cart
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.saveCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
    }

    // Update an existing cart
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Integer id, @RequestBody Cart cartDetails) {
        Cart updatedCart = cartService.updateCart(id, cartDetails);
        return updatedCart != null ? ResponseEntity.ok(updatedCart)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a cart
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Integer id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
