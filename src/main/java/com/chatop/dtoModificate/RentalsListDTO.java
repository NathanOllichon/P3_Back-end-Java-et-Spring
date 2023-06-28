package com.chatop.dtoModificate;

import java.util.List;

import com.chatop.model.RentalsDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RentalsListDTO {

	List<RentalsDTO> rentals;
	
}
