package com.chatop.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chatop.mapper.RentalsMapper;
import com.chatop.model.Rentals;
import com.chatop.model.RentalsDTO;
import com.chatop.serviceImpl.RentalsServiceImpl;


@RestController
public class RentalsController {

    @Autowired
    private RentalsServiceImpl rentalsService;

    //TODO responseEntity for all
    @GetMapping("/rentals")
    public ResponseEntity<List<RentalsDTO>> getAllRentals() {
    	System.out.println("get rentals entry");
    	return new ResponseEntity<>(rentalsService.getAllRentals(), HttpStatus.OK);
    }
    
    @GetMapping("/rentals/{id}")
    public ResponseEntity<RentalsDTO> getRentals(@PathVariable("id") final Long id) {

		RentalsDTO rentalsDTO = RentalsMapper.MAPPER.mapToRentalsDto(rentalsService.getRentals(id));
		
         return new ResponseEntity<>(rentalsDTO, HttpStatus.OK);
    }
    
    @PostMapping("/rentals")
    public ResponseEntity<String> createRentals(@RequestParam("name") String name, @RequestParam("surface") int surface, 
    		@RequestParam("price") int price, @RequestPart("picture") MultipartFile pictureFile, @RequestParam("description") String description) {
    	String pictureFileURL;
    	URL url;
		try {
			System.out.println("11111 mcghbhjbkj ");
			//System.out.println(pictureFile.getResource().getFilename());
			System.out.println("22222 mcghbhjbkj ");
			Resource a = pictureFile.getResource();
			System.out.println("333333 mcghbhjbkj ");
			System.out.println(a.toString());
			System.out.println(a.exists());
			System.out.println(a.isFile());
			System.out.println(a.getURL());

			//System.out.println(a.getAbsolutePath());
			System.out.println(pictureFile.getResource().getURI());
			System.out.println("44444 mcghbhjbkj ");
			
			System.out.println(pictureFile.getResource().getURL());

			
			url = pictureFile.getResource().getURL();
			System.out.println(url);
			System.out.println(url.getPath());
			pictureFileURL = pictureFile.getName();//pictureFile.getResource().getURL();
		} catch (IOException e) {
	    	return new ResponseEntity<>("Issue on file URL" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	rentalsService.createRentals(name, surface, price, pictureFileURL, description); //Create how manage ID ?
    	return new ResponseEntity<>("Rental created !", HttpStatus.OK);
    }
    
    @PutMapping("/rentals/{id}")
    public ResponseEntity<String> putRentals(@PathVariable("id") final Long id, @RequestParam("name") String name, @RequestParam("surface") int surface, 
    		@RequestParam("price") int price, @RequestParam("description") String description) {
        	rentalsService.updateRentals(id, name, surface, price, description);

    	return new ResponseEntity<>("Rental updated !", HttpStatus.OK);
    }
    
}
