package org.isdb.ProjectBackend.controller.login.tCon;

import org.isdb.ProjectBackend.dto.table.InventoryDTO;
import org.isdb.ProjectBackend.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Get all Inventories
    @GetMapping
    public List<InventoryDTO> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    // Get Inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable Long id) {
        Optional<InventoryDTO> inventoryDTO = inventoryService.getInventoryById(id);
        return inventoryDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or Update Inventory
    @PostMapping
    public ResponseEntity<InventoryDTO> createOrUpdateInventory(@RequestBody InventoryDTO inventoryDTO) {
        InventoryDTO savedInventory = inventoryService.saveOrUpdateInventory(inventoryDTO);
        return ResponseEntity.ok(savedInventory);
    }

    // Delete Inventory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }
}
