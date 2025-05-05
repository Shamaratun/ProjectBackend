package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.model.Wishlist;
import org.isdb.ProjectBackend.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public List<Wishlist> getAllWishlists() {
        return wishlistRepository.findAll();
    }

    public Optional<Wishlist> getWishlistById(Integer id) {
        return wishlistRepository.findById(id);
    }

    public void deleteWishlist(Integer id) {
        wishlistRepository.deleteById(id);
    }
}