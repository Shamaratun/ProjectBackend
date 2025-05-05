package org.isdb.ProjectBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//CartItem.java
@Entity
@Table(name = "CartItem")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer cartItemID;

	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "cartID")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "bookID")
	private Books book;
}
