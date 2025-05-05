package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderID;

    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "discountID")
    private Discount discount;

    @OneToOne
    @JoinColumn(name = "paymentID")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "shippingID")
    private Shipping shipping;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
