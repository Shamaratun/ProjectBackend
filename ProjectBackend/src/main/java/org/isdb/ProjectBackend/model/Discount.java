package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	private Long discountID;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, length = 100)
	private String description;

	private BigDecimal discountPercentage;

	private LocalDate startDate;

	private LocalDate endDate;

	@Column(nullable = false, length = 100)
	private String criteria;

	@OneToMany(mappedBy = "discount")
	@JoinColumn(name = "orderID", nullable = false)
	private List<Order> orders;
}