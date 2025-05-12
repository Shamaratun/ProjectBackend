package org.isdb.ProjectBackend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long paymentID;
	@Column(nullable = false, length = 100)
	private String paymentMethod;

	private LocalDateTime paymentDate;

	private BigDecimal amount;

	@Column(nullable = false, length = 100)
	private String transactionStatus;

	@OneToOne(mappedBy = "payment")
	private Order order;
}
