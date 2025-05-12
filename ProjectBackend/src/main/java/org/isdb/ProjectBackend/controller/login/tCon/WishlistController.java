package org.isdb.ProjectBackend.controller.login.tCon;

import org.isdb.ProjectBackend.model.Wishlist;
import org.isdb.ProjectBackend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlists")
@CrossOrigin(origins = "http://localhost:4200")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    // Get all wishlists
    @GetMapping
    public ResponseEntity<List<Wishlist>> getAllWishlists() {
        List<Wishlist> wishlists = wishlistService.getAllWishlists();
        if (wishlists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wishlists, HttpStatus.OK);
    }

    // Get wishlist by ID
    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getWishlistById(@PathVariable Long id) {
        Optional<Wishlist> wishlist = wishlistService.getWishlistById(id);
        return wishlist.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new wishlist
    @PostMapping
    public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist) {
        if (wishlist.getTitle() == null || wishlist.getTitle().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Example field validation
        }

        Wishlist createdWishlist = wishlistService.saveWishlist(wishlist);
        return new ResponseEntity<>(createdWishlist, HttpStatus.CREATED);
    }

    // Update wishlist by ID
    @PutMapping("/{id}")
    public ResponseEntity<Wishlist> updateWishlist(@PathVariable Integer id, @RequestBody Wishlist updatedWishlist) {
        Optional<Wishlist> existingWishlist = wishlistService.getWishlistById(id);
        if (!existingWishlist.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        updatedWishlist.setWishlistID(id);
        Wishlist savedWishlist = wishlistService.saveWishlist(updatedWishlist);
        return new ResponseEntity<>(savedWishlist, HttpStatus.OK);
    }

    // Delete wishlist by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Integer id) {
        Optional<Wishlist> existingWishlist = wishlistService.getWishlistById(id);
        if (!existingWishlist.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wishlistService.deleteWishlist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
