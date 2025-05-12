package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;

import org.isdb.ProjectBackend.dto.table.WarehouseDTO;
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
@CrossOrigin(origins = "http://localhost:4200")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;

	@GetMapping
	public ResponseEntity<List<WarehouseDTO>> getAll() {
		return ResponseEntity.ok(warehouseService.getAllWarehouses());
	}

	@GetMapping("/{id}")
	public ResponseEntity<WarehouseDTO> getById(@PathVariable Long id) {
		return warehouseService.getWarehouseById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<WarehouseDTO> create(@RequestBody WarehouseDTO dto) {
		return ResponseEntity.ok(warehouseService.saveWarehouse(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<WarehouseDTO> update(@PathVariable Long id, @RequestBody WarehouseDTO dto) {
		WarehouseDTO updated = warehouseService.updateWarehouse(id, dto);
		return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return warehouseService.deleteWarehouse(id) ? ResponseEntity.noContent().build()
				: ResponseEntity.notFound().build();
	}
}
