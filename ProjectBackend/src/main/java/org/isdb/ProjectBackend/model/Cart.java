package org.isdb.ProjectBackend.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long cartID;

	private LocalDateTime createdDate;

	private	String status;

	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;

	@OneToMany(mappedBy = "cart")
	private List<CartItem> items;
}
