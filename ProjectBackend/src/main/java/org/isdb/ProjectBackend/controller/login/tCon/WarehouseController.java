package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.isdb.ProjectBackend.dto.table.WarehouseDTO;
import org.isdb.ProjectBackend.model.Warehouse;
import org.isdb.ProjectBackend.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouses")
@CrossOrigin(origins = "http://localhost:4200") // FIXED: must include protocol + host
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;

	@GetMapping
	public List<WarehouseDTO> getAllWarehouses() {
		return warehouseService.getAllWarehouses().stream().map(WarehouseDTO::fromEntity).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<WarehouseDTO> getWarehouseById(@PathVariable Integer id) {
		Optional<Warehouse> warehouse = warehouseService.getWarehouseById(id);
		return warehouse.map(w -> ResponseEntity.ok(WarehouseDTO.fromEntity(w)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<WarehouseDTO> createWarehouse(@RequestBody WarehouseDTO warehouseDTO) {
		Warehouse warehouse = warehouseService.saveWarehouse(WarehouseDTO.toEntity(warehouseDTO));
		return ResponseEntity.ok(WarehouseDTO.fromEntity(warehouse));
	}

	@PutMapping("/{id}")
	public ResponseEntity<WarehouseDTO> updateWarehouse(@PathVariable Integer id,
			@RequestBody WarehouseDTO warehouseDTO) {
		Warehouse updated = warehouseService.updateWarehouse(id, WarehouseDTO.toEntity(warehouseDTO));
		if (updated != null) {
			return ResponseEntity.ok(WarehouseDTO.fromEntity(updated));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWarehouse(@PathVariable Integer id) {
		warehouseService.deleteWarehouse(id);
		return ResponseEntity.noContent().build();
	}
}
