package org.isdb.ProjectBackend.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "BookDiscount")
public class BookDiscount {
	@EmbeddedId
	private BookDiscount id;

	@ManyToOne
	@MapsId("bookID")
	@JoinColumn(name = "bookID")
	private Books book;

	@ManyToOne
	@MapsId("discountID")
	@JoinColumn(name = "discountID")
	private Discount discount;
}
