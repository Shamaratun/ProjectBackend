//package org.isdb.ProjectBackend.model;
//
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//
//import org.springframework.data.annotation.Id;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "Books")
//public class Book {
//	@Id
//	private Integer bookID;
//
//	private String title;
//	private String isbn;
//	private BigDecimal price;
//	private Integer stock;
//	private String image;
//	private String genre;
//	private BigDecimal rating;
//
//	@Column(name = "created_at")
//	private Timestamp createdAt;
//
//	@Column(name = "updated_at")
//	private Timestamp updatedAt;
//
//	@ManyToOne
//	@JoinColumn(name = "authorID")
//	private Author author;
//
//	@ManyToOne
//	@JoinColumn(name = "warehouseID")
//	private Warehouse warehouse;
//
//	// Relationships (mappedBy should be added in the other classes)
//}
