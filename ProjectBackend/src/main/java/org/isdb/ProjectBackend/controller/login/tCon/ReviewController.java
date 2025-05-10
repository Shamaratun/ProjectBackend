package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;

import org.isdb.ProjectBackend.dto.table.ReviewDTO;
import org.isdb.ProjectBackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping
	public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
		ReviewDTO createdReview = reviewService.createReview(reviewDTO);
		return ResponseEntity.ok(createdReview);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Integer id) {
		ReviewDTO review = reviewService.getReviewById(id);
		return ResponseEntity.ok(review);
	}

	@GetMapping
	public ResponseEntity<List<ReviewDTO>> getAllReviews() {
		List<ReviewDTO> reviews = reviewService.getAllReviews();
		return ResponseEntity.ok(reviews);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReviewDTO> updateReview(@PathVariable Integer id, @RequestBody ReviewDTO reviewDTO) {
		ReviewDTO updated = reviewService.updateReview(id, reviewDTO);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
		reviewService.deleteReview(id);
		return ResponseEntity.noContent().build();
	}
}
