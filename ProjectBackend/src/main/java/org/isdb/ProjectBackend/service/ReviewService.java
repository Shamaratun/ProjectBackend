package org.isdb.ProjectBackend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.isdb.ProjectBackend.dto.table.ReviewDTO;
import org.isdb.ProjectBackend.model.Review;
import org.isdb.ProjectBackend.model.User;
import org.isdb.ProjectBackend.repository.BooksRepository;
import org.isdb.ProjectBackend.repository.ReviewRepository;
import org.isdb.ProjectBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BooksRepository booksRepository;

	public ReviewDTO createReview(ReviewDTO dto) {
		Optional<User> userOpt = userRepository.findById(dto.getUserID());

		if (userOpt.isEmpty()) {
			throw new IllegalArgumentException("Invalid UserID ");
		}

		Review review = new Review();
		review.setUser(userOpt.get());

		review.setRating(dto.getRating());
		review.setComment(dto.getComment());
		review.setReviewDate(LocalDateTime.now());

		Review saved = reviewRepository.save(review);
		return mapToDTO(saved);
	}

	public ReviewDTO getReviewById(Long id) {
		return reviewRepository.findById(id).map(this::mapToDTO)
				.orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + id));
	}

	public List<ReviewDTO> getAllReviews() {
		return reviewRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public ReviewDTO updateReview(Long id, ReviewDTO dto) {
		Review review = reviewRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Review not found with ID: " + id));

		review.setRating(dto.getRating());
		review.setComment(dto.getComment());
		review.setReviewDate(LocalDateTime.now());

		return mapToDTO(reviewRepository.save(review));
	}

	public void deleteReview(Long id) {
		if (!reviewRepository.existsById(id)) {
			throw new IllegalArgumentException("Review not found with ID: " + id);
		}
		reviewRepository.deleteById(id);
	}

	private ReviewDTO mapToDTO(Review review) {
		return new ReviewDTO(review.getId(), review.getUser().getId(), review.getBook().getBookID(), review.getRating(),
				review.getComment(), review.getReviewDate());
	}
}
