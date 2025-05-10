package org.isdb.ProjectBackend.controller.login.tCon;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.OrderItem;
import org.isdb.ProjectBackend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-items")
@CrossOrigin(origins = "http://localhost:4200") 

public class OrderItemController {

	@Autowired
	private OrderItemRepository orderItemRepository;

	// Get all order items
	@GetMapping
	public List<OrderItem> getAllOrderItems() {
		return orderItemRepository.findAll();
	}

	// Get order item by ID
	@GetMapping("/{id}")
	public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Integer id) {
		Optional<OrderItem> orderItem = orderItemRepository.findById(id);
		return orderItem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Create a new order item
	@PostMapping
	public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	// Update an existing order item
	@PutMapping("/{id}")
	public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Integer id, @RequestBody OrderItem updatedItem) {
		return orderItemRepository.findById(id).map(existingItem -> {
			existingItem.setQuantity(updatedItem.getQuantity());
			existingItem.setPrice(updatedItem.getPrice());
			existingItem.setOrder(updatedItem.getOrder());
			existingItem.setBook(updatedItem.getBook());
			orderItemRepository.save(existingItem);
			return ResponseEntity.ok(existingItem);
		}).orElse(ResponseEntity.notFound().build());
	}
}