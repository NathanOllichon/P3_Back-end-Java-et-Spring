package com.chatop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessagesDTO {

	private Long id;

	private Long rental_id;

	private Long user_id;
	
	private String message;
	
	private String created_at;

	private String updated_at;
	
}
