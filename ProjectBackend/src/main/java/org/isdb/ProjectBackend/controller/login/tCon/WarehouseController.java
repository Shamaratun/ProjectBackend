package org.isdb.ProjectBackend.controller.login.tCon;

import org.isdb.ProjectBackend.dto.table.WarehouseDTO;
import org.isdb.ProjectBackend.model.Warehouse;
import org.isdb.ProjectBackend.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public List<WarehouseDTO> getAllWarehouses() {
        return warehouseService.getAllWarehouses()
                .stream()
                .map(WarehouseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDTO> getWarehouseById(@PathVariable Integer id) {
        Optional<Warehouse> warehouse = warehouseService.getWarehouseById(id);
        return warehouse.map(w -> ResponseEntity.ok(WarehouseDTO.fromEntity(w)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<WarehouseDTO> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse saved = warehouseService.saveWarehouse(warehouse);
        return ResponseEntity.ok(WarehouseDTO.fromEntity(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseDTO> updateWarehouse(@PathVariable Integer id, @RequestBody Warehouse updatedWarehouse) {
        Warehouse updated = warehouseService.updateWarehouse(id, updatedWarehouse);
        if (updated != null) {
            return ResponseEntity.ok(WarehouseDTO.fromEntity(updated));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable Integer id) {
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.noContent().build();
    }
}
