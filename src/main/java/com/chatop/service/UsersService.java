package com.chatop.service;

import com.chatop.dto.UsersJsonDTO;
import com.chatop.model.Users;

public interface UsersService {

	Users getUsers(Long id);

	void registerUser(UsersJsonDTO usersJsonDTO);

	Users isLoginValid(String mail, String password);

}
