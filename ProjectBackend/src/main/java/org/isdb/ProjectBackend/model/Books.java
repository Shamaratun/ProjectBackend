package org.isdb.ProjectBackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // or another strategy you prefer
	private Integer id;

	private String title;
	private String isbn;
	private Double price;
	private Integer stock;
	private String image;
	private String genre;
	private Double rating;

	private String author;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

//	@ManyToOne
//	@JoinColumn(name = "warehouseID",referencedColumnName = "id", nullable = false)
//	private Warehouse warehouse;

	// Relationships (mappedBy should be added in the other classes)
}
