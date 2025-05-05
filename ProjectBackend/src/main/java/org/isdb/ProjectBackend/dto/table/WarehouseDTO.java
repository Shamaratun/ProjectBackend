package org.isdb.ProjectBackend.dto.table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.isdb.ProjectBackend.model.Warehouse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDTO {
    private Integer warehouseID;
    private String location;
    private Integer stockLevel;
//    private Integer bookID;

    public static WarehouseDTO fromEntity(Warehouse warehouse) {
        WarehouseDTO dto = new WarehouseDTO();
        dto.setWarehouseID(warehouse.getWarehouseID());
        dto.setLocation(warehouse.getLocation());
        dto.setStockLevel(warehouse.getStockLevel());
//        dto.setBookID(warehouse.getBooks().getFirst());
        return dto;
    }
}