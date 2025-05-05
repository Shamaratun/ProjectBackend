package org.isdb.ProjectBackend.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Wishlist")
public class Wishlist {
	@Id
	private Integer wishlistID;

	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;

// 	@OneToMany(mappedBy = "wishlist")
// 	private List<WishlistItem> items;
// }