package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookID;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false, length = 50)
	private Integer isbn;

	private BigDecimal price;

	private Integer stock;

	private String image;

	@Column(nullable = false, length = 100)
	private String genre;

	private BigDecimal rating;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@ManyToOne
	@JoinColumn(name = "authorID", referencedColumnName = "authorID", nullable = false)
	private Author author;

	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;
	// Relationships (mappedBy should be added in the other classes)
}
