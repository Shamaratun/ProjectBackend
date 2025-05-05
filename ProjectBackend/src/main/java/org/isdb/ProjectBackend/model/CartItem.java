package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
