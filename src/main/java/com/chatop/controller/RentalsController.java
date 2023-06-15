package com.chatop.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.model.RentalsDTO;
import com.chatop.serviceImpl.RentalsServiceImpl;


@RestController
public class RentalsController {

    @Autowired
    private RentalsServiceImpl rentalsService;

    //TODO responseEntity for all
    @GetMapping("/rentals")
    public ResponseEntity<List<RentalsDTO>> getAllRentals() {
    	return new ResponseEntity<>(rentalsService.getAllRentals(), HttpStatus.OK);
    }
    
    @GetMapping("/rentals/{id}")
    public ResponseEntity<RentalsDTO> getRentals(@PathVariable("id") final Long id) {
         return new ResponseEntity<>(rentalsService.getRentals(id), HttpStatus.OK);
    }
    
    @PostMapping("/rentals")
    public ResponseEntity<String> createRentals(@RequestParam("name") String name, @RequestParam("surface") int surface, 
    		@RequestParam("price") int price, @RequestParam("picture") File pictureFile, @RequestParam("description") String description) {
    	rentalsService.createRentals(name, surface, price, pictureFile, description); //Create how manage ID ?
    	return new ResponseEntity<>("Rental created !", HttpStatus.OK);
    }
    
    @PutMapping("/rentals/{id}")
    public ResponseEntity<String> putRentals(@PathVariable("id") final Long id, @RequestParam("name") String name, @RequestParam("surface") int surface, 
    		@RequestParam("price") int price, @RequestParam("description") String description) {
        	rentalsService.updateRentals(id, name, surface, price, description);

    	return new ResponseEntity<>("Rental updated !", HttpStatus.OK);
    }
    
}
