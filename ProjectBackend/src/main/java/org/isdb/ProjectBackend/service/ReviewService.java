package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.dto.table.ReviewDTO;
import org.isdb.ProjectBackend.model.Review;
import org.isdb.ProjectBackend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        // Create a new Review entity from DTO and save to the repository
        Review review = new Review();
        review.setReviewDate(reviewDTO.getReviewDate());
        // Map other fields from DTO to Review entity
        Review savedReview = reviewRepository.save(review);
        return ReviewDTO.fromEntity(savedReview);
    }

    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        return review != null ? ReviewDTO.fromEntity(review) : null;
    }

    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(ReviewDTO::fromEntity).collect(Collectors.toList());
    }

    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
            review.setReviewDate(reviewDTO.getReviewDate());
            // Map other fields
            Review updatedReview = reviewRepository.save(review);
            return ReviewDTO.fromEntity(updatedReview);
        }
        return null;
    }

    public boolean deleteReview(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            reviewRepository.delete(review.get());
            return true;  // Successfully deleted
        }
        return false;  // Review not found
    }
}
