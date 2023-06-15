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
import com.chatop.repository.RentalsRepository;
import com.chatop.service.RentalsService;

@Service
public class RentalsServiceImpl implements RentalsService {

	@Autowired
	private RentalsRepository rentalsRepository;

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
	public RentalsDTO getRentals(final Long id) {

		Optional<Rentals> optionnalrentals = rentalsRepository.findById(id);
		Rentals rentals = optionnalrentals.get();
		RentalsDTO rentalsDTO = RentalsMapper.MAPPER.mapToRentalsDto(rentals);

		return rentalsDTO;
	}

	@Override
	public Rentals createRentals(String name, int surface, int price, File pictureFile, String description) {

		String created_at = ""; // Timestamp.;
		String update_at = null;

		// TODO pictureFile insert URL, see spec techniques
		Rentals rentals = new Rentals(null, name, surface, price, pictureFile.getPath(), description, created_at,
				update_at, update_at);

		return rentals;
	}

	@Override
	public Rentals updateRentals(Long id, String name, int surface, int price, String description) {
		Optional<Rentals> optionalRentals = rentalsRepository.findById(id);

		String update_at = null; // Timestamp.;

		if (optionalRentals.isPresent()) {
			Rentals rentals = optionalRentals.get();

			rentals.setName(name);
			rentals.setSurface(surface);
			rentals.setPrice(price);
			rentals.setDescription(description);
			rentals.setUpdated_at(update_at);

			rentalsRepository.save(rentals);

			return rentals;
		}

		return null;
	}

}