package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderID;

	private LocalDateTime orderDate;
	@Column(nullable = false, length = 100)
	private String status;

	private BigDecimal totalAmount;
//
//	@ManyToOne
//	@JoinColumn(name = "userID")
//	private User user;
//
//	@ManyToOne
//	@JoinColumn(name = "discountID")
//	private Discount discount;
//
//	@OneToOne
//	@JoinColumn(name = "paymentID")
//	private Payment payment;
//
//	@OneToOne
//	@JoinColumn(name = "shippingID")
//	private Shipping shipping;
//
//	@OneToMany(mappedBy = "order")
//	private List<OrderItem> orderItems;
}
