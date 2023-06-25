package com.chatop.service;

import com.chatop.dtoJson.UsersJsonDTO;
import com.chatop.model.Users;
import com.chatop.model.UsersDTO;

public interface UsersService {

	Users getUsers(Long id);

	void registerUser(UsersJsonDTO usersJsonDTO);

}
