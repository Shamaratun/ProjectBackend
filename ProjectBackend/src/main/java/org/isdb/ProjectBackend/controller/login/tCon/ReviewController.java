package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;

import org.isdb.ProjectBackend.dto.table.ReviewDTO;
import org.isdb.ProjectBackend.model.Review;
import org.isdb.ProjectBackend.service.ReviewService;
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
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// Create Review
	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Review review) {
		// Call service method to create the review
		Review createdReview = reviewService.createReview(review);
		return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
	}

	// Get Review by ID
	@GetMapping("/{id}")
	public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Integer id) {
		ReviewDTO review = reviewService.getReviewById(id);
		if (review != null) {
			return new ResponseEntity<>(review, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Get all Reviews
	@GetMapping
	public ResponseEntity<List<ReviewDTO>> getAllReviews() {
		List<ReviewDTO> reviews = reviewService.getAllReviews();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	// Update Review
	@PutMapping("/{id}")
	public ResponseEntity<ReviewDTO> updateReview(@PathVariable Integer id, @RequestBody ReviewDTO reviewDTO) {
		ReviewDTO updated = reviewService.updateReview(id, reviewDTO);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete Review
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
		reviewService.deleteReview(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
