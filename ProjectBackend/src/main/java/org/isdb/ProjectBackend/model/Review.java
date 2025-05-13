package org.isdb.ProjectBackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReviewID")
	private Long reviewID;

//	@ManyToOne
//	@JoinColumn(name = "UserId", nullable = false)
//	private User user;
//
//	@ManyToOne
//	@JoinColumn(name = "BookId", nullable = false)
//	private Books book;

	@Column(name = "Rating")
	private Integer rating;

	@Column(name = "Comment", columnDefinition = "TEXT")
	private String comment;

	@Column(name = "ReviewDate")
	private LocalDateTime reviewDate;
}
