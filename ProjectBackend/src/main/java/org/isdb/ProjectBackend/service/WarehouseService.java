package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.isdb.ProjectBackend.dto.table.WarehouseDTO;
import org.isdb.ProjectBackend.model.Warehouse;
import org.isdb.ProjectBackend.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {

	@Autowired
	private WarehouseRepository warehouseRepository;

	public List<WarehouseDTO> getAllWarehouses() {
		return warehouseRepository.findAll().stream().map(WarehouseDTO::fromEntity).collect(Collectors.toList());
	}

	public Optional<WarehouseDTO> getWarehouseById(Long id) {
		return warehouseRepository.findById(id).map(WarehouseDTO::fromEntity);
	}

	public WarehouseDTO saveWarehouse(WarehouseDTO dto) {
		Warehouse saved = warehouseRepository.save(WarehouseDTO.toEntity(dto));
		return WarehouseDTO.fromEntity(saved);
	}

	public WarehouseDTO updateWarehouse(Long id, WarehouseDTO dto) {
		Optional<Warehouse> optional = warehouseRepository.findById(id);
		if (optional.isPresent()) {
			Warehouse existing = optional.get();
			existing.setLocation(dto.getLocation());
			existing.setStockLevel(dto.getStockLevel());
			Warehouse updated = warehouseRepository.save(existing);
			return WarehouseDTO.fromEntity(updated);
		}
		return null;
	}

	public boolean deleteWarehouse(Long id) {
		if (warehouseRepository.existsById(id)) {
			warehouseRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
