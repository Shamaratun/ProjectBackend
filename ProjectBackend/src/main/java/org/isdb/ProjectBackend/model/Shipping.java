package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Shipping")
public class Shipping {
	@Id
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
