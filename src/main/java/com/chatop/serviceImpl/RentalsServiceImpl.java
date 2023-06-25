package com.chatop.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.mapper.RentalsMapper;
import com.chatop.model.Rentals;
import com.chatop.model.RentalsDTO;
import com.chatop.model.Users;
import com.chatop.repository.RentalsRepository;
import com.chatop.service.RentalsService;

@Service
public class RentalsServiceImpl implements RentalsService {

	@Autowired
	private RentalsRepository rentalsRepository;
	
	private UsersServiceImpl usersServiceImpl;

	@Override
	public List<RentalsDTO> getAllRentals() {

		List<Rentals> listRentals = rentalsRepository.findAll();
		List<RentalsDTO> listRentalsDTO = new ArrayList<RentalsDTO>();
		for (Rentals rentals : listRentals) {
			listRentalsDTO.add(RentalsMapper.MAPPER.mapToRentalsDto(rentals));
		}
		return listRentalsDTO;
	}

	@Override
	public Rentals getRentals(final Long id) {

		Optional<Rentals> optionnalrentals = rentalsRepository.findById(id);
		Rentals rentals = optionnalrentals.get();
//		RentalsDTO rentalsDTO = RentalsMapper.MAPPER.mapToRentalsDto(rentals);

		return rentals;
	}

	@Override
	public Rentals createRentals(String name, int surface, int price, String pictureFile, String description) {

		//TODO replace by same method then get/me !
		Long owner_id = (long) 1;
		Users owner = usersServiceImpl.getUsers(owner_id);

		// TODO pictureFile insert URL, see spec techniques
		//TODO 1 should be owner_id ! 
		Rentals rentals = new Rentals(null, owner, name, surface, price, pictureFile, description, null,
				null);

		return rentals;
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