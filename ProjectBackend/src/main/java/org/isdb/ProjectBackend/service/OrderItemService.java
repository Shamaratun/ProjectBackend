package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.model.OrderItem;
import org.isdb.ProjectBackend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    // Get all order items
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    // Get order item by ID
    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    // Create a new order item
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // Update an existing order item
    public Optional<OrderItem> updateOrderItem(Long id, OrderItem updatedItem) {
        return orderItemRepository.findById(id).map(existingItem -> {
            existingItem.setQuantity(updatedItem.getQuantity());
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setOrder(updatedItem.getOrder());
            existingItem.setBook(updatedItem.getBook());
            orderItemRepository.save(existingItem);
            return existingItem;
        });
    }

    // Delete an order item
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
