package org.isdb.ProjectBackend.dto.table;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
	private Integer reviewID;
	private Integer rating;
	private String comment;
	private LocalDateTime reviewDate;
	private long userID;
	private Integer bookID;
}
