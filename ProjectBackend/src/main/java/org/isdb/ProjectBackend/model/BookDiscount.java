package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "BookDiscount")
public class BookDiscount {
    @EmbeddedId
    private BookDiscount id;

    @ManyToOne
    @MapsId("bookID")
    @JoinColumn(name = "bookID")
    private Books book;

    @ManyToOne
    @MapsId("discountID")
    @JoinColumn(name = "discountID")
    private Discount discount;
}
