package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Order;
import org.isdb.ProjectBackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	// Save Order
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	// Get all Orders
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	// Get Order by ID
	public Optional<Order> getOrderById(Integer id) {
		return orderRepository.findById(id);
	}

	// Delete Order by ID
	public void deleteOrderById(Integer id) {
		orderRepository.deleteById(id);
	}
}