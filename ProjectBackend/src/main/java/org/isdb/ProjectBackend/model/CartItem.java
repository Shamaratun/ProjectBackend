package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CartItem")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartItemID;

	@ManyToOne
	@JoinColumn(name = "cartID", nullable = false)
	@JsonBackReference
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "bookID", nullable = false)
	@JsonBackReference
	private Books book;

	private Integer quantity;

	private BigDecimal priceAtAddTime;

	private LocalDateTime addedAt;
}
