package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.model.CartItem;
import org.isdb.ProjectBackend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

  
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

   
    public Optional<CartItem> getCartItemById(Long id) {
        return cartItemRepository.findById(id);
    }

 
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

   
    public CartItem updateCartItem(Long id, CartItem cartItemDetails) {
        Optional<CartItem> existingCartItem = cartItemRepository.findById(id);
        if (existingCartItem.isPresent()) {
            CartItem updatedCartItem = existingCartItem.get();
            updatedCartItem.setQuantity(cartItemDetails.getQuantity());
            updatedCartItem.setCart(cartItemDetails.getCart());
            updatedCartItem.setBook(cartItemDetails.getBook());
            return cartItemRepository.save(updatedCartItem);
        }
        return null;
    }

  
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}
