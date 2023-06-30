package com.chatop.dto;

import java.sql.Timestamp;

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

	private Long owner_id;
	
	private Timestamp created_at;

	private Timestamp updated_at;
	
}
