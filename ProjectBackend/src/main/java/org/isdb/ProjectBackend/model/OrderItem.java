package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderItem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderItemID;

	private Integer quantity;

	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "orderID")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "bookID")
	private Books book;
}
