package com.chatop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chatop.dto.RentalsDTO;
import com.chatop.model.Rentals;

@Mapper
public interface RentalsMapper {

	RentalsMapper MAPPER = Mappers.getMapper(RentalsMapper.class);

	RentalsDTO mapToRentalsDto(Rentals rental);

	Rentals mapToRentals(RentalsDTO rentalsDTO);    
}