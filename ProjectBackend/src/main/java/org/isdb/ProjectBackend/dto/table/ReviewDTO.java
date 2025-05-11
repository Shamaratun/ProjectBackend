package org.isdb.ProjectBackend.dto.table;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
	private Long reviewID;
	private Long userID;
	private Integer bookID;
	private Integer rating;
	private String comment;
	private LocalDateTime reviewDate;
}
