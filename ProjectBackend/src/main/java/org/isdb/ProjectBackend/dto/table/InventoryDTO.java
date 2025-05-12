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
public class InventoryDTO {

	private Long inventoryID;
	private Integer quantity;
	private LocalDateTime lastUpdated;
	private Long bookID; // Only send book ID, not the full Book entity
	private Long warehouseID;
}