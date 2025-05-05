package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Discount")
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer discountID;

	private String name;
	private String description;
	private BigDecimal discountPercentage;
	private LocalDate startDate;
	private LocalDate endDate;
	private String criteria;

	@OneToMany(mappedBy = "discount")
	private List<Order> orders;
}