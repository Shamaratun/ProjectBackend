package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Review;
import org.isdb.ProjectBackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Review review) {
		return ResponseEntity.ok(reviewService.saveReview(review));
	}

	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews() {
		return ResponseEntity.ok(reviewService.getAllReviews());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable Integer id) {
		Optional<Review> review = reviewService.getReviewById(id);
		return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable Integer id, @RequestBody Review updatedReview) {
		Optional<Review> existing = reviewService.getReviewById(id);
		if (existing.isPresent()) {
			updatedReview.setReviewID(id); // Ensure correct ID is set
			return ResponseEntity.ok(reviewService.saveReview(updatedReview));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
		reviewService.deleteReviewById(id);
		return ResponseEntity.noContent().build();
	}
}