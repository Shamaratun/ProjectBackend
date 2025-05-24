package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Discount")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long discountId;

	@Column(nullable = true, length = 100)
	private String name;

	@Column(nullable = false, length = 100)
	private String description;

	@Column(nullable = true)
	private BigDecimal discountPercentage;

	@Column(nullable = true, length = 100)
	private String criteria;

	@OneToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Books book;
}
