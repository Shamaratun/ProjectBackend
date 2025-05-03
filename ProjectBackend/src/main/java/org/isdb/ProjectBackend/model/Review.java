//package org.isdb.ProjectBackend.model;
//
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "Review")
//public class Review {
//	@Id
//	private Integer reviewID;
//
//	private Integer rating;
//	private String comment;
//	private LocalDateTime reviewDate;
//
//	@ManyToOne
//	@JoinColumn(name = "userID")
//	private User user;
//
//	@ManyToOne
//	@JoinColumn(name = "bookID")
//	private Book book;
//}