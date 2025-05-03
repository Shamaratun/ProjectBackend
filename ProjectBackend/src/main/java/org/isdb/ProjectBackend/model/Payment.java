//package org.isdb.ProjectBackend.model;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "Payment")
//public class Payment {
//	@Id
//	private Integer paymentID;
//
//	private String paymentMethod;
//	private LocalDateTime paymentDate;
//	private BigDecimal amount;
//	private String transactionStatus;
//
//	@OneToOne(mappedBy = "payment")
//	private Order order;
//}
