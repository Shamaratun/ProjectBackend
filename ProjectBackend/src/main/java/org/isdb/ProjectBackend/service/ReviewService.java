package org.isdb.ProjectBackend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.isdb.ProjectBackend.dto.table.ReviewDTO;
import org.isdb.ProjectBackend.model.Books;
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
		Review review = new Review();
		review.setRating(dto.getRating());
		review.setComment(dto.getComment());
		review.setReviewDate(LocalDateTime.now());

		User user = userRepository.findById(dto.getUserID()).orElseThrow(() -> new RuntimeException("User not found"));
		Books book = booksRepository.findById(dto.getBookID())
				.orElseThrow(() -> new RuntimeException("Book not found"));

		review.setUser(user);
		review.setBook(book);

		Review saved = reviewRepository.save(review);
		return convertToDTO(saved);
	}

	public ReviewDTO getReviewById(Integer id) {
		Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
		return convertToDTO(review);
	}

	public List<ReviewDTO> getAllReviews() {
		return reviewRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public void deleteReview(Integer id) {
		reviewRepository.deleteById(id);
	}

	public ReviewDTO updateReview(Integer id, ReviewDTO dto) {
		Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));

		review.setRating(dto.getRating());
		review.setComment(dto.getComment());

		if (dto.getBookID() != null) {
			Books book = booksRepository.findById(dto.getBookID())
					.orElseThrow(() -> new RuntimeException("Book not found"));
			review.setBook(book);
		}

		Review updated = reviewRepository.save(review);
		return convertToDTO(updated);
	}

	private ReviewDTO convertToDTO(Review review) {
		ReviewDTO dto = new ReviewDTO();
		dto.setReviewID(review.getReviewID());
		dto.setRating(review.getRating());
		dto.setComment(review.getComment());
		dto.setReviewDate(review.getReviewDate());

		dto.setBookID(review.getBook().getBookID());
		return dto;
	}
}
