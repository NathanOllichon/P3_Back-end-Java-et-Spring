package com.chatop.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RentalsListDTO {

	List<RentalsDTO> rentals;
	
}
