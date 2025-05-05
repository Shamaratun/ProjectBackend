package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.model.Warehouse;
import org.isdb.ProjectBackend.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public Optional<Warehouse> getWarehouseById(Integer id) {
        return warehouseRepository.findById(id);
    }

    public Warehouse saveWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    public Warehouse updateWarehouse(Integer id, Warehouse updatedWarehouse) {
        Optional<Warehouse> existing = warehouseRepository.findById(id);
        if (existing.isPresent()) {
            Warehouse warehouse = existing.get();
            // warehouse.setLocation(updatedWarehouse.getLocation());
            // warehouse.setStockLevel(updatedWarehouse.getStockLevel());
            return warehouseRepository.save(warehouse);
        }
        return null;
    }

    public void deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id);
    }
}
