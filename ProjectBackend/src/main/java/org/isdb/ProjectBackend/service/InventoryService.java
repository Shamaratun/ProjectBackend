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
        dto.setInventoryId(inventory.getInventoryId());
        dto.setQuantity(inventory.getQuantity());
        dto.setLastUpdated(inventory.getLastUpdated());
        dto.setBookId(inventory.getBook().getBookId());   // Assuming Book entity has a getBookId() method
        dto.setWarehouseId(inventory.getWarehouse().getWarehouseId()); // Assuming Warehouse has a getWarehouseId() method
        return dto;
    }

    // Get all inventories
    public List<InventoryDTO> getAllInventories() {
        return inventoryRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get Inventory by Id
    public Optional<InventoryDTO> getInventoryById(Long id) {
        return inventoryRepository.findById(id).map(this::toDTO);
    }

    // Save or Update Inventory
    public InventoryDTO saveOrUpdateInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(inventoryDTO.getInventoryId());
        inventory.setQuantity(inventoryDTO.getQuantity());
        inventory.setLastUpdated(inventoryDTO.getLastUpdated());

        // Assuming you have methods to get the book and warehouse from Ids
        // Example: bookService.findById(inventoryDTO.getBookId())
        // Example: warehouseService.findById(inventoryDTO.getWarehouseId())

        // Save the inventory to the database
        Inventory savedInventory = inventoryRepository.save(inventory);
        return toDTO(savedInventory);
    }

    // Delete Inventory by Id
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
