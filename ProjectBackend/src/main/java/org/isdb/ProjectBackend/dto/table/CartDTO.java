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
	private Long id; // Assuming User has userID
private String status;
	private Long cartID;
	// Assuming CartItemDTO is defined elsewhere

	// Add any additional fields or methods as needed
}