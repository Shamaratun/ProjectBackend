package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;


@Entity
@Table(name = "WishlistItem")
public class WishlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
