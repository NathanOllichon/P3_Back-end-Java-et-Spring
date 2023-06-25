package com.chatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.mapper.UsersMapper;
import com.chatop.model.UsersDTO;
import com.chatop.serviceImpl.UsersServiceImpl;

@RestController
public class UsersController {

	@Autowired
	private UsersServiceImpl usersService;

	@GetMapping("/user/{id}")
	public UsersDTO getUsers(@PathVariable("id") final Long id) {
    	UsersDTO userDTO = UsersMapper.MAPPER.mapToUsersDto(usersService.getUsers(id));
		return userDTO;
	}

	//@GetMapping("/auth/me")
	//public Optional<Users> getUsersMe() {
	//  Final Long id = ???find user_id, how ???
	//	return usersService.getUsers(id);
	//}
	
}
