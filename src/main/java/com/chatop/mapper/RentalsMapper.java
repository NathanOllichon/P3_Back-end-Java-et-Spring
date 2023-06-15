package com.chatop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chatop.model.Rentals;
import com.chatop.model.RentalsDTO;

@Mapper
public interface RentalsMapper {

	RentalsMapper MAPPER = Mappers.getMapper(RentalsMapper.class);

	RentalsDTO mapToRentalsDto(Rentals optional);

	Rentals mapToRentals(RentalsDTO rentalsDTO);
    
}