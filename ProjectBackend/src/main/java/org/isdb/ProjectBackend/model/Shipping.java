package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer shippingID;

    private String address;
    private String city;
    private String country;
    private String deliveryMethod;
    private String estimatedDeliveryTime;
    private BigDecimal shippingCost;

    @OneToOne(mappedBy = "shipping")
    private Order order;
}
