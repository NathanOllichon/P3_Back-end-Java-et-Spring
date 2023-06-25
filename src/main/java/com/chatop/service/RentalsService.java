package com.chatop.service;

import java.util.List;

import com.chatop.model.Rentals;
import com.chatop.model.RentalsDTO;

public interface RentalsService {

	List<RentalsDTO> getAllRentals();

	Rentals getRentals(Long id);

	Rentals updateRentals(Long id, String name, int surface, int price, String description);

	Rentals createRentals(String name, int surface, int price, String pictureFile, String description);

}
