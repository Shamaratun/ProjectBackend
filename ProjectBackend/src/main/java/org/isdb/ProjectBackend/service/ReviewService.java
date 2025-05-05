package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review saveReview(Review review);

    List<Review> getAllReviews();

    Optional<Review> getReviewById(Integer id);

    void deleteReviewById(Integer id);
}
