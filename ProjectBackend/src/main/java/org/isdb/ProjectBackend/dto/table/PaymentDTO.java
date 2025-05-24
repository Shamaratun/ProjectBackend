package org.isdb.ProjectBackend.dto.table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
	private Long paymentId;
	private String paymentMethod;
	private LocalDateTime paymentDate;
	private BigDecimal amount;
	private String transactionStatus;
	private Long orderId;
}