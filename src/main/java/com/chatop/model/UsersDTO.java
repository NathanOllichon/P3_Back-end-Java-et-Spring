package com.chatop.model;

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
	
	private String password;
	
	private String created_at;

	private String updated_at;
	
}
