package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Discount;
import org.isdb.ProjectBackend.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/discounts")
@CrossOrigin(origins = "http://localhost:4200") 
public class DiscountController {

	@Autowired
	private DiscountService discountService;

	// Get all discounts
	@GetMapping
	public List<Discount> getAllDiscounts() {
		return discountService.getAllDiscounts();
	}

	// Get a discount by ID
	@GetMapping("/{id}")
	public ResponseEntity<Discount> getDiscountById(@PathVariable Long id) {
		Optional<Discount> discount = discountService.getDiscountById(id);
		return discount.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	// Create a new discount
	@PostMapping
	public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
		Discount savedDiscount = discountService.saveDiscount(discount);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedDiscount);
	}

	// Update an existing discount
	@PutMapping("/{id}")
	public ResponseEntity<Discount> updateDiscount(@PathVariable Long id, @RequestBody Discount discountDetails) {
		Discount updatedDiscount = discountService.updateDiscount(id, discountDetails);
		return updatedDiscount != null ? ResponseEntity.ok(updatedDiscount)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// Delete a discount
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
		discountService.deleteDiscount(id);
		return ResponseEntity.noContent().build();
	}
}