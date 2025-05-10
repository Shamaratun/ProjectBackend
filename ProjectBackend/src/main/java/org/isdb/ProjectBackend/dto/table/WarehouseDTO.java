package org.isdb.ProjectBackend.dto.table;

import org.isdb.ProjectBackend.model.Warehouse;

public class WarehouseDTO {
	private Integer warehouseID;
	private String location;
	private Integer stockLevel;

	// Entity to DTO
	public static WarehouseDTO fromEntity(Warehouse warehouse) {
		WarehouseDTO dto = new WarehouseDTO();
		dto.setWarehouseID(warehouse.getWarehouseID());
		dto.setLocation(warehouse.getLocation());
		dto.setStockLevel(warehouse.getStockLevel());
		return dto;
	}

	// DTO to Entity
	public static Warehouse toEntity(WarehouseDTO dto) {
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseID(dto.getWarehouseID());
		warehouse.setLocation(dto.getLocation());
		warehouse.setStockLevel(dto.getStockLevel());
		return warehouse;
	}

	// Getters and Setters
	public Integer getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Integer warehouseID) {
		this.warehouseID = warehouseID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(Integer stockLevel) {
		this.stockLevel = stockLevel;
	}
}
