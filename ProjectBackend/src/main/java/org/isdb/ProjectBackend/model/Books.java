
package org.isdb.ProjectBackend.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "M_Books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BookId")
	private Long bookId;

	private String title;
	private String authorName;

	private String isbn;
	private Double price;
	private Integer stock;
	private String image;
	private String genre;
	private Double rating;
	private String warehouseLocation;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "author_Id")
	@JsonBackReference(value = "book-author")
	private Author author;

	@ManyToOne
	@JoinColumn(name = "warehouse_Id")
	@JsonBackReference(value = "book-warehouse")
	private Warehouse warehouse;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "book-review")
	private List<Review> reviews;

}
