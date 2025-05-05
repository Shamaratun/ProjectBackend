package org.isdb.ProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.ProjectBackend.model.Discount;
import org.isdb.ProjectBackend.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

	@Autowired
	private DiscountRepository discountRepository;

	// Get all discounts
	public List<Discount> getAllDiscounts() {
		return discountRepository.findAll();
	}

	// Get a discount by ID
	public Optional<Discount> getDiscountById(Integer id) {
		return discountRepository.findById(id);
	}

	// Save a new discount
	public Discount saveDiscount(Discount discount) {
		return discountRepository.save(discount);
	}

	// Update an existing discount
	public Discount updateDiscount(Integer id, Discount discountDetails) {
		Optional<Discount> existingDiscount = discountRepository.findById(id);
		if (existingDiscount.isPresent()) {
			Discount updatedDiscount = existingDiscount.get();
			updatedDiscount.setName(discountDetails.getName());
			updatedDiscount.setDescription(discountDetails.getDescription());
			updatedDiscount.setDiscountPercentage(discountDetails.getDiscountPercentage());
			updatedDiscount.setStartDate(discountDetails.getStartDate());
			updatedDiscount.setEndDate(discountDetails.getEndDate());
			updatedDiscount.setCriteria(discountDetails.getCriteria());
			return discountRepository.save(updatedDiscount);
		}
		return null; // Handle case where discount does not exist
	}

	// Delete a discount by ID
	public void deleteDiscount(Integer id) {
		discountRepository.deleteById(id);
	}


	}
}