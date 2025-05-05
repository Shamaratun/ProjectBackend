package org.isdb.ProjectBackend.dto.table;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.isdb.ProjectBackend.model.Author;
import org.isdb.ProjectBackend.model.Warehouse;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookDTO {

	private Integer classId;

	private String title;
	private String isbn;
	private BigDecimal price;
	private Integer stock;
	private String image;
	private String genre;
	private BigDecimal rating;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	    @ManyToOne
	    @JoinColumn(name = "authorID")
	    private Author author;

	    @ManyToOne
	    @JoinColumn(name = "warehouseID")
	    private Warehouse warehouse;
}
