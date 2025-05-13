
package org.isdb.ProjectBackend.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Books implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BookId") // Match Oracle column name here
	private Long bookId;

	private String title;
	private String isbn;
	private Double price;
	private Integer stock;
	private String image;
	private String genre;
	private Double rating;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "author_Id")
	@JsonBackReference
	private Author author;

	@ManyToOne
	@JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId", nullable = false)
	private Warehouse warehouse;

	@OneToMany
	private List<Review> reviews;

}
