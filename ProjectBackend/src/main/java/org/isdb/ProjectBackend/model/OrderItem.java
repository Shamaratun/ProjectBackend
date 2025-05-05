package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

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
