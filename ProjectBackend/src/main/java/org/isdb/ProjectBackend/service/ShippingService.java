package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Shipping;
import org.isdb.ProjectBackend.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

	@Autowired
	private ShippingRepository shippingRepository;

	// Save Shipping
	public Shipping saveShipping(Shipping shipping) {
		return shippingRepository.save(shipping);
	}

	// Get all Shippings
	public List<Shipping> getAllShippings() {
		return shippingRepository.findAll();
	}

	// Get Shipping by ID
	public Optional<Shipping> getShippingById(Integer id) {
		return shippingRepository.findById(id);
	}

	// Delete Shipping by ID
	public void deleteShippingById(Integer id) {
		shippingRepository.deleteById(id);
	}
}