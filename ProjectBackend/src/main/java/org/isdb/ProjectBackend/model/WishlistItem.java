package org.isdb.ProjectBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "WishlistItem")
public class WishlistItem {
	@Id
	private Integer wishlistItemID;

	@ManyToOne
	@JoinColumn(name = "wishlistID")
	private Wishlist wishlist;

	@ManyToOne
	@JoinColumn(name = "bookID")
	private Books book;

    public Object getBook() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getBook'");
    }
}
