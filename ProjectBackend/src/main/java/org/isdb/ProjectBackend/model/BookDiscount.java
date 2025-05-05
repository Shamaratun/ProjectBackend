package org.isdb.ProjectBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BookDiscount")
public class BookDiscount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BookDiscount id;

	@ManyToOne
//	@MapsId("bookID")
	@JoinColumn(name = "bookID")
	private Books book;

	@ManyToOne
//	@MapsId("discountID")
	@JoinColumn(name = "discountID")
	private Discount discount;
}
