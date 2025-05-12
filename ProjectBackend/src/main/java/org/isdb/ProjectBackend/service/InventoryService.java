package org.isdb.ProjectBackend.service;



import org.isdb.ProjectBackend.dto.table.InventoryDTO;
import org.isdb.ProjectBackend.model.Inventory;
import org.isdb.ProjectBackend.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Convert Entity to DTO
    private InventoryDTO toDTO(Inventory inventory) {
        InventoryDTO dto = new InventoryDTO();
        dto.setInventoryID(inventory.getInventoryID());
        dto.setQuantity(inventory.getQuantity());
        dto.setLastUpdated(inventory.getLastUpdated());
        dto.setBookID(inventory.getBook().getBookID());   // Assuming Book entity has a getBookID() method
        dto.setWarehouseID(inventory.getWarehouse().getWarehouseID()); // Assuming Warehouse has a getWarehouseID() method
        return dto;
    }

    // Get all inventories
    public List<InventoryDTO> getAllInventories() {
        return inventoryRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get Inventory by ID
    public Optional<InventoryDTO> getInventoryById(Long id) {
        return inventoryRepository.findById(id).map(this::toDTO);
    }

    // Save or Update Inventory
    public InventoryDTO saveOrUpdateInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory();
        inventory.setInventoryID(inventoryDTO.getInventoryID());
        inventory.setQuantity(inventoryDTO.getQuantity());
        inventory.setLastUpdated(inventoryDTO.getLastUpdated());

        // Assuming you have methods to get the book and warehouse from IDs
        // Example: bookService.findById(inventoryDTO.getBookID())
        // Example: warehouseService.findById(inventoryDTO.getWarehouseID())

        // Save the inventory to the database
        Inventory savedInventory = inventoryRepository.save(inventory);
        return toDTO(savedInventory);
    }

    // Delete Inventory by ID
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
