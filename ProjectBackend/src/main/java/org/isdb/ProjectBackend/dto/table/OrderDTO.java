package org.isdb.ProjectBackend.dto.table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
	private Integer orderID;
	private LocalDateTime orderDate;
	private String status;
	private BigDecimal totalAmount;
	private Integer userID;
	private Integer discountID;
	private Integer paymentID;
	private Integer shippingID;
	private List<Integer> orderItemIDs;
}
