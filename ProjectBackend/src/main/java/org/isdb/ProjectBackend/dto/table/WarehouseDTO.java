package org.isdb.ProjectBackend.dto.table;

import org.isdb.ProjectBackend.model.Warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDTO {
	private Long warehouseId;
	private String location;
	private Integer stockLevel;

	// Entity to DTO
	public static WarehouseDTO fromEntity(Warehouse warehouse) {
		WarehouseDTO dto = new WarehouseDTO();
		dto.setWarehouseId(warehouse.getWarehouseId()); // map entity field to DTO
		dto.setLocation(warehouse.getLocation());
		dto.setStockLevel(warehouse.getStockLevel());
		return dto;
	}

	// DTO to Entity
	public static Warehouse toEntity(WarehouseDTO dto) {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseId(dto.getWarehouseId()); // map DTO field to entity
		warehouse.setLocation(dto.getLocation());
		warehouse.setStockLevel(dto.getStockLevel());
		return warehouse;
	}
}