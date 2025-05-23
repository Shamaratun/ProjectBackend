package org.isdb.ProjectBackend.dto.table;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookDTO {

	private Integer bookId;

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

//	    @ManyToOne
//	    @JoinColumn(name = "authorID")
//	    private Author author;
//
//	    @ManyToOne
//	    @JoinColumn(name = "warehouseID")
//	    private Warehouse warehouse;
}
