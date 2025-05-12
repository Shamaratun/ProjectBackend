package org.isdb.ProjectBackend.dto.table;

import org.isdb.ProjectBackend.model.Warehouse;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDTO {
    private Long warehouseID;
    private String location;
    private Integer stockLevel;

    // Entity to DTO
    public static WarehouseDTO fromEntity(Warehouse warehouse) {
        WarehouseDTO dto = new WarehouseDTO();
        dto.setWarehouseID(warehouse.getWarehouseID());  // map entity field to DTO
        dto.setLocation(warehouse.getLocation());
        dto.setStockLevel(warehouse.getStockLevel());
        return dto;
    }

    // DTO to Entity
    public static Warehouse toEntity(WarehouseDTO dto) {
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseID(dto.getWarehouseID());  // map DTO field to entity
        warehouse.setLocation(dto.getLocation());
        warehouse.setStockLevel(dto.getStockLevel());
        return warehouse;
    }}