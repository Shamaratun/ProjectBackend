//package org.isdb.ProjectBackend.model;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "Order")
//public class Order {
//	@Id
//	private Integer orderID;
//
//	private LocalDateTime orderDate;
//	private String status;
//	private BigDecimal totalAmount;
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
//}
