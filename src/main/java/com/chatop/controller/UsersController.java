package com.chatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dto.UsersDTO;
import com.chatop.mapper.UsersMapper;
import com.chatop.serviceImpl.UsersServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Users", description = "Users route APIs")
@RestController
public class UsersController {

	@Autowired
	private UsersServiceImpl usersService;

	@Operation(summary = "Get data from user with id requested", 
			description = "Route for get data from user with id requested. The response is a DTO with data from the user, exclude creation and update dates")
	@GetMapping("/user/{id}")
	public UsersDTO getUsers(@PathVariable("id") final Long id) {
    	UsersDTO userDTO = UsersMapper.MAPPER.mapToUsersDto(usersService.getUsers(id));
		return userDTO;
	}
	
}
