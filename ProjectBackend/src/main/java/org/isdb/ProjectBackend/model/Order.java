package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	private Long orderId;

	private LocalDateTime orderDate;
	@Column(nullable = false, length = 100)
	private String status;

	private BigDecimal totalAmount;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "discountId")
	private Discount discount;

	@OneToOne
	@JoinColumn(name = "paymentId")
	private Payment payment;

	@OneToOne
	@JoinColumn(name = "shippingId")
	private Shipping shipping;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;
}
