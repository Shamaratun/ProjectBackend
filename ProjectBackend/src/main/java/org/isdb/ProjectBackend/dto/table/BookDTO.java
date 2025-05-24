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

	public String title;
	public String authoName;
	public Integer isbn;
	public String warehouseLocation;

	public String image;
	public String genre;

	@Column(name = "created_at")
	public Timestamp createdAt;

	@Column(name = "updated_at")
	public Timestamp updatedAt;

	public Long authorId;
	public Long warehouseId;
	public Integer stock;
	public BigDecimal price;
	public BigDecimal rating;
//	@ManyToOne
//	@JoinColumn(name = "authorId")
//	private Author author;
//
//	@ManyToOne
//	@JoinColumn(name = "warehouseId")
//	private Warehouse warehouse;
}
