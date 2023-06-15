package com.chatop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

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

	//TODO Something ? Key
	private String owner_id;
	
	private String created_at;

	private String updated_at;
	
	
}
