package com.chatop.service;

import java.util.List;

import com.chatop.dto.RentalsDTO;
import com.chatop.dto.RentalsListDTO;
import com.chatop.model.Rentals;

public interface RentalsService {

	RentalsListDTO getAllRentals();

	Rentals getRentals(Long id);

	Rentals updateRentals(Long id, String name, int surface, int price, String description);

	void createRentals(String name, int surface, int price, String pictureFile, String description, Long owner_id);

}
