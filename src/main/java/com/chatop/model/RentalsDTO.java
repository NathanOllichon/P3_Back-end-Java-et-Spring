package com.chatop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentalsDTO {

	private Long id;

	private String name;

	private int surface;

	private int price;
	
	private String picture;
	
	private String description;

	private Users owner;
	
}
