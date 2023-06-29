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
public class UsersDTO {

	private Long id;

	private String email;

	private String name;
	
	private Timestamp created_at;

	private Timestamp updated_at;
}
