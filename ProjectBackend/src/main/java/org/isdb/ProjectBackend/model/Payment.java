package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer paymentID;

	private String paymentMethod;
	private LocalDateTime paymentDate;
	private BigDecimal amount;
	private String transactionStatus;

	@OneToOne(mappedBy = "payment")
	private Order order;
}
