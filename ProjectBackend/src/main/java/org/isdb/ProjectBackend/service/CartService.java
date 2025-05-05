package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.model.Cart;
import org.isdb.ProjectBackend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Get all carts
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // Get a cart by ID
    public Optional<Cart> getCartById(Integer id) {
        return cartRepository.findById(id);
    }

    // Save a new cart
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Update an existing cart
    public Cart updateCart(Integer id, Cart cartDetails) {
        Optional<Cart> existingCart = cartRepository.findById(id);
        if (existingCart.isPresent()) {
            Cart updatedCart = existingCart.get();
            updatedCart.setUser(cartDetails.getUser());
            updatedCart.setCreatedDate(cartDetails.getCreatedDate());
            return cartRepository.save(updatedCart);
        }
        return null; // Handle case where cart does not exist
    }

    // Delete a cart by ID
    public void deleteCart(Integer id) {
        cartRepository.deleteById(id);
    }
}
