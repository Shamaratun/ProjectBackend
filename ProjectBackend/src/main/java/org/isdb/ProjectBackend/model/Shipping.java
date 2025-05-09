package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name = "Shipping")
public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer shippingID;
	@Column(nullable = false, length = 100)
	private String address;
	@Column(nullable = false, length = 100)
	private String city;
	@Column(nullable = false, length = 100)
	private String country;
	@Column(nullable = false, length = 100)
	private String deliveryMethod;

	private String estimatedDeliveryTime;

	private BigDecimal shippingCost;

	@OneToOne(mappedBy = "shipping")
	private Order order;
}
