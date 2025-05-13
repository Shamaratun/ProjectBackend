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

	private Long inventoryId;
	private Integer quantity;
	private LocalDateTime lastUpdated;
	private Long bookId; // Only send book Id, not the full Book entity
	private Long warehouseId;
}