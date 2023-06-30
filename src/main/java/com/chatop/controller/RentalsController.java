package com.chatop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chatop.dto.RentalsDTO;
import com.chatop.dto.RentalsListDTO;
import com.chatop.dto.RentalsResponseDTO;
import com.chatop.mapper.RentalsMapper;
import com.chatop.model.Users;
import com.chatop.service.TokenService;
import com.chatop.serviceImpl.RentalsServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Rentals", description = "Rentals route APIs")
@RestController
public class RentalsController {

	@Autowired
	private RentalsServiceImpl rentalsService;

	@Autowired
	private TokenService tokenService;

	@Operation(summary = "Get all rentals", 
			description = "Route for get all rentals informations. The response is a DTO with a list of DTO containing rentals informations.")
	@GetMapping("/rentals")
	public ResponseEntity<RentalsListDTO> getAllRentals() {
		return new ResponseEntity<>(rentalsService.getAllRentals(), HttpStatus.OK);
	}

	@Operation(summary = "Get data from rental requested", 
			description = "Route for get data from rental with id requested. The response is a DTO with data from the rental requested.")
	@GetMapping("/rentals/{id}")
	public ResponseEntity<RentalsDTO> getRentals(@PathVariable("id") final Long id) {
		RentalsDTO rentalsDTO = RentalsMapper.MAPPER.mapToRentalsDto(rentalsService.getRentals(id));
		return new ResponseEntity<>(rentalsDTO, HttpStatus.OK);
	}

	@Operation(summary = "Route for create rental data", 
			description = "Route for create a rental on database. The response is a DTO with a rental result of this request. \n The owner is get by authentificate token decoded. The picture is store on backend resources/pictures and route store at URL from server.")
	@PostMapping("/rentals")
	public ResponseEntity<RentalsResponseDTO> createRentals(@RequestParam("name") String name,
			@RequestParam("surface") int surface, @RequestParam("price") int price,
			@RequestPart("picture") MultipartFile pictureFile, @RequestParam("description") String description,
			@Parameter(description = "Authentificate header, string token JWT")@RequestHeader("Authorization") String token) {

		Users owner = tokenService.validateJwtToken(token);

		String serverPath = "http://localhost:3001/api/pictures/" + pictureFile.getOriginalFilename();
		String localPath = "C:/Users/Compt/OneDrive/Bureau/Alternance/Ecole/Projet 3/P3_Back-end-Java-et-Spring/src/main/resources/public/pictures/"  + pictureFile.getOriginalFilename();
		
		//copy file to "localPath" on server path exposed to front server. 
		try {
			byte[] bytes = pictureFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(localPath)));
			stream.write(bytes);
			stream.close();

		} catch (IllegalStateException | IOException e) {
			RentalsResponseDTO rentalRequestDTO = new RentalsResponseDTO("Issue on rental creation, impossible to store picture. " + e.getMessage());
			return new ResponseEntity<>(rentalRequestDTO, HttpStatus.BAD_REQUEST);
		}
		
		rentalsService.createRentals(name, surface, price, serverPath, description, owner.getId());

		RentalsResponseDTO rentalRequestDTO = new RentalsResponseDTO("Rental created !");
		return new ResponseEntity<>(rentalRequestDTO, HttpStatus.OK);
	}

	@Operation(summary = "Put data on rental requested", 
			description = "Route for put data on rental with id requested. This put it's an update of rental. The response is a DTO with a message result of this request.")
	@PutMapping("/rentals/{id}")
	public ResponseEntity<RentalsResponseDTO> putRentals(@PathVariable("id") final Long id,
			@RequestParam("name") String name, @RequestParam("surface") int surface, @RequestParam("price") int price,
			@RequestParam("description") String description) {
		rentalsService.updateRentals(id, name, surface, price, description);
		RentalsResponseDTO rentalRequestDTO = new RentalsResponseDTO("Rental updated !");
		return new ResponseEntity<>(rentalRequestDTO, HttpStatus.OK);
	}

}
