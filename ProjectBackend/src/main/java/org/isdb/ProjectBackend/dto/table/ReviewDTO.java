package org.isdb.ProjectBackend.dto.table;

import java.time.LocalDateTime;

import org.isdb.ProjectBackend.model.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
	private Long reviewID;
	private Long id;
	private Integer bookID;
	private Integer rating;
	private String comment;
	private LocalDateTime reviewDate;
	public static ReviewDTO fromEntity(Review savedReview) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'fromEntity'");
	}
}
