package org.isdb.ProjectBackend.dto.table;

import org.isdb.ProjectBackend.model.Warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDTO {
	private Integer warehouseID;
	private String location;
	private Integer stockLevel;

	public static WarehouseDTO fromEntity(Warehouse warehouse) {
		WarehouseDTO dto = new WarehouseDTO();
		dto.setWarehouseID(warehouse.getWarehouseID());
		dto.setLocation(warehouse.getLocation());
		dto.setStockLevel(warehouse.getStockLevel());
		return dto;
	}

	public static Warehouse toEntity(WarehouseDTO dto) {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseID(dto.getWarehouseID());
		warehouse.setLocation(dto.getLocation());
		warehouse.setStockLevel(dto.getStockLevel());
		return warehouse;
	}
}
