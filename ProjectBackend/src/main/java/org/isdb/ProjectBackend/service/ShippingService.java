package org.isdb.ProjectBackend.service;

import org.isdb.ProjectBackend.model.Shipping;
import org.isdb.ProjectBackend.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

   
    public Shipping saveShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }


    public List<Shipping> getAllShippings() {
        return shippingRepository.findAll();
    }

   
    public Optional<Shipping> getShippingById(Long id) {
        return shippingRepository.findById(id);
    }


    public void deleteShippingById(Long id) {
        shippingRepository.deleteById(id);
    }
}