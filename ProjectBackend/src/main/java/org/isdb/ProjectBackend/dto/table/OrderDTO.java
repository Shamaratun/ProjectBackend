package org.isdb.ProjectBackend.dto.table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	private Long orderId;
	private LocalDateTime orderDate;
	private String status;
	private BigDecimal totalAmount;
	private Integer userId;
	private Integer discountId;
	private Integer paymentId;
	private Integer shippingId;
	private List<Integer> orderItemIds;
}
