package com.chatop.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.dtoModificate.RentalsListDTO;
import com.chatop.mapper.RentalsMapper;
import com.chatop.model.Rentals;
import com.chatop.model.RentalsDTO;
import com.chatop.repository.RentalsRepository;
import com.chatop.service.RentalsService;

@Service
public class RentalsServiceImpl implements RentalsService {

	@Autowired
	private RentalsRepository rentalsRepository;

	@Override
	public RentalsListDTO getAllRentals() {
		
		List<Rentals> listRentals = rentalsRepository.findAll();
		List<RentalsDTO> listRentalsDTO = new ArrayList<RentalsDTO>();
		for (Rentals rentals : listRentals) {
			listRentalsDTO.add(RentalsMapper.MAPPER.mapToRentalsDto(rentals));
		}
		
		RentalsListDTO rentalsList = new RentalsListDTO(listRentalsDTO);
		return rentalsList;
//		return listRentalsDTO;
	}

	@Override
	public Rentals getRentals(final Long id) {

		Optional<Rentals> optionnalrentals = rentalsRepository.findById(id);
		Rentals rentals = optionnalrentals.get();

		return rentals;
	}

	@Override
	public void createRentals(String name, int surface, int price, String pictureFile, String description, Long owner_id) {

		Rentals rentals = new Rentals(null, owner_id, name, surface, price, pictureFile, description, null,
				null);
		
		rentalsRepository.save(rentals);
	}

	@Override
	public Rentals updateRentals(Long id, String name, int surface, int price, String description) {
		Optional<Rentals> optionalRentals = rentalsRepository.findById(id);

		if (optionalRentals.isPresent()) {
			Rentals rentals = optionalRentals.get();

			rentals.setName(name);
			rentals.setSurface(surface);
			rentals.setPrice(price);
			rentals.setDescription(description);

			rentalsRepository.save(rentals);

			return rentals;
		}

		return null;
	}

}