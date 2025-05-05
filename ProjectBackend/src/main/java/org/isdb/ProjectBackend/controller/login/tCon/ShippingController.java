package org.isdb.ProjectBackend.controller.login.tCon;

import org.isdb.ProjectBackend.model.Shipping;
import org.isdb.ProjectBackend.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    // Save Shipping
    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {
        Shipping savedShipping = shippingService.saveShipping(shipping);
        return new ResponseEntity<>(savedShipping, HttpStatus.CREATED);
    }

    // Get all Shippings
    @GetMapping
    public ResponseEntity<List<Shipping>> getAllShippings() {
        List<Shipping> shippings = shippingService.getAllShippings();
        return new ResponseEntity<>(shippings, HttpStatus.OK);
    }

    // Get Shipping by ID
    @GetMapping("/{id}")
    public ResponseEntity<Shipping> getShippingById(@PathVariable Integer id) {
        Optional<Shipping> shipping = shippingService.getShippingById(id);
        if (shipping.isPresent()) {
            return new ResponseEntity<>(shipping.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Shipping by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingById(@PathVariable Integer id) {
        shippingService.deleteShippingById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}