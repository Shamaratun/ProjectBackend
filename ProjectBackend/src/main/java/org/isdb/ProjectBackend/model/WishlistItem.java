package org.isdb.ProjectBackend.model;

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
@Table(name = "WishlistItem")
public class WishlistItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishlistItemID;

	@ManyToOne
	@JoinColumn(name = "wishlistID")
	private Wishlist wishlist;

	@ManyToOne
	@JoinColumn(name = "bookID")
	private Books book;

}
