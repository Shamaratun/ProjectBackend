// package org.isdb.ProjectBackend.controller.login.tCon;

// import org.isdb.ProjectBackend.model.Wishlist;
// import org.isdb.ProjectBackend.service.WishlistService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/wishlists")
// public class WishlistController {

//     @Autowired
//     private WishlistService wishlistService;

//     @PostMapping
//     public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist) {
//         return ResponseEntity.ok(wishlistService.saveWishlist(wishlist));
//     }

//     @GetMapping
//     public List<Wishlist> getAllWishlists() {
//         return wishlistService.getAllWishlists();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Wishlist> getWishlistById(@PathVariable Integer id) {
//         Optional<Wishlist> wishlist = wishlistService.getWishlistById(id);
//         return wishlist.map(ResponseEntity::ok)
//                        .orElse(ResponseEntity.notFound().build());
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Wishlist> updateWishlist(@PathVariable Integer id, @RequestBody Wishlist updatedWishlist) {
//         Optional<Wishlist> existing = wishlistService.getWishlistById(id);
//         if (existing.isPresent()) {
//             updatedWishlist.setWishlistID(id);
//             return ResponseEntity.ok(wishlistService.saveWishlist(updatedWishlist));
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteWishlist(@PathVariable Integer id) {
//         if (wishlistService.getWishlistById(id).isPresent()) {
//             wishlistService.deleteWishlist(id);
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }