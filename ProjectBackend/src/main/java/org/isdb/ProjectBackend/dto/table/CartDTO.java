package org.isdb.ProjectBackend.dto.table;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CartDTO {

	private LocalDateTime createdDate;
	private Long Id; // Assuming User has userId
private String status;
	private Long cartId;
	// Assuming CartItemDTO is defined elsewhere

	// Add any additional fields or methods as needed
}