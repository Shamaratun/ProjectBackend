package org.isdb.ProjectBackend.controller.login.tCon;

import org.isdb.ProjectBackend.model.OrderItem;
import org.isdb.ProjectBackend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-items")
@CrossOrigin(origins = "http://localhost:4200") 
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    // Get all order items
    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    // Get order item by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        Optional<OrderItem> orderItem = orderItemService.getOrderItemById(id);
        return orderItem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Create a new order item
    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    // Update an existing order item
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long id, @RequestBody OrderItem updatedItem) {
        Optional<OrderItem> updated = orderItemService.updateOrderItem(id, updatedItem);
        return updated.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Delete an order item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
