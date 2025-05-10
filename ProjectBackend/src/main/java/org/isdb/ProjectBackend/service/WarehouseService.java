package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Warehouse;
import org.isdb.ProjectBackend.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return warehouseRepository.findById(id).map(existing -> {

			existing.setLocation(updatedWarehouse.getLocation());
			// Add other field updates as necessary
			return warehouseRepository.save(existing);
		}).orElse(null);
	}

	public boolean deleteWarehouse(Integer id) {
		if (warehouseRepository.existsById(id)) {
			warehouseRepository.deleteById(id);
			return true;
		}
		return false;
	}
}