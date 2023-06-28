package com.chatop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.List;

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

import com.chatop.dtoModificate.RentalsListDTO;
import com.chatop.dtoModificate.RentalsResponseDTO;
import com.chatop.mapper.RentalsMapper;
import com.chatop.model.RentalsDTO;
import com.chatop.model.Users;
import com.chatop.service.TokenService;
import com.chatop.serviceImpl.RentalsServiceImpl;

@RestController
public class RentalsController {

	@Autowired
	private RentalsServiceImpl rentalsService;

	@Autowired
	private TokenService tokenService;

	@GetMapping("/rentals")
	public ResponseEntity<RentalsListDTO> getAllRentals() {
		System.out.println("get rentals entry");
		return new ResponseEntity<>(rentalsService.getAllRentals(), HttpStatus.OK);
	}

	@GetMapping("/rentals/{id}")
	public ResponseEntity<RentalsDTO> getRentals(@PathVariable("id") final Long id) {

		RentalsDTO rentalsDTO = RentalsMapper.MAPPER.mapToRentalsDto(rentalsService.getRentals(id));

		return new ResponseEntity<>(rentalsDTO, HttpStatus.OK);
	}

	@PostMapping("/rentals")
	public ResponseEntity<RentalsResponseDTO> createRentals(@RequestParam("name") String name,
			@RequestParam("surface") int surface, @RequestParam("price") int price,
			@RequestPart("picture") MultipartFile pictureFile, @RequestParam("description") String description,
			@RequestHeader("Authorization") String token) {

		Users owner = tokenService.validateJwtToken(token);

		// TODO in swagger ! actually we store in local, this should work if the server
		// and client are on same machine.
		// We do that because we haven't any server for store this image !
		String filePath = "src/main/resources/pictures/" + pictureFile.getOriginalFilename();
		String baseCPath = "C:/Users/Compt/OneDrive/Bureau/Alternance/Ecole/Projet 3/P3_Back-end-Java-et-Spring/";
		String completePicturePath = baseCPath + filePath;
		try {

			byte[] bytes = pictureFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(bytes);
			stream.close();

		} catch (IllegalStateException | IOException e) {
			RentalsResponseDTO rentalRequestDTO = new RentalsResponseDTO("Issue on rental creation, impossible to store picture. " + e.getMessage());

			return new ResponseEntity<>(rentalRequestDTO, HttpStatus.BAD_REQUEST);
		}

		rentalsService.createRentals(name, surface, price, completePicturePath, description, owner.getId());

		RentalsResponseDTO rentalRequestDTO = new RentalsResponseDTO("Rental created !");
		return new ResponseEntity<>(rentalRequestDTO, HttpStatus.OK);
	}

	@PutMapping("/rentals/{id}")
	public ResponseEntity<RentalsResponseDTO> putRentals(@PathVariable("id") final Long id,
			@RequestParam("name") String name, @RequestParam("surface") int surface, @RequestParam("price") int price,
			@RequestParam("description") String description) {
		rentalsService.updateRentals(id, name, surface, price, description);
		RentalsResponseDTO rentalRequestDTO = new RentalsResponseDTO("Rental updated !");
		return new ResponseEntity<>(rentalRequestDTO, HttpStatus.OK);
	}

}
