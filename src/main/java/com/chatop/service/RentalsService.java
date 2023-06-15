package com.chatop.service;

import java.io.File;
import java.util.List;

import com.chatop.model.Rentals;
import com.chatop.model.RentalsDTO;

public interface RentalsService {

	List<RentalsDTO> getAllRentals();

	RentalsDTO getRentals(Long id);

	Rentals createRentals(String name, int surface, int price, File pictureFile, String description);

	Rentals updateRentals(Long id, String name, int surface, int price, String description);

}
