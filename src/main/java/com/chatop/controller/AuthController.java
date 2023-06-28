package com.chatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dtoModificate.CredentialsJsonDTO;
import com.chatop.dtoModificate.TokenDTO;
import com.chatop.dtoModificate.UsersJsonDTO;
import com.chatop.mapper.UsersMapper;
import com.chatop.model.Users;
import com.chatop.model.UsersDTO;
import com.chatop.service.TokenService;
import com.chatop.serviceImpl.UsersServiceImpl;

@RestController
public class AuthController {

	@Autowired
	private UsersServiceImpl usersService;

	private final TokenService tokenService;

	public AuthController(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@CrossOrigin
	@PostMapping("/auth/register")
	@ResponseBody
	public TokenDTO register(@RequestBody UsersJsonDTO usersJsonDTO) {
		usersService.registerUser(usersJsonDTO);
		String token = tokenService.generateToken(usersJsonDTO.getEmail());
		TokenDTO tokenDTO = new TokenDTO(token);
		return tokenDTO;
	}

	@CrossOrigin
	@PostMapping("/auth/login")
	@ResponseBody
	public TokenDTO login(@RequestBody CredentialsJsonDTO credentialsJsonDTO) {
		Users user = usersService.isLoginValid(credentialsJsonDTO.getEmail(), credentialsJsonDTO.getPassword());

		String token = tokenService.generateToken(user.getEmail());
		TokenDTO tokenDTO = new TokenDTO(token);
		return tokenDTO;
	}

	@CrossOrigin
	@GetMapping("/auth/me")
	@ResponseBody
	public UsersDTO getMe(@RequestHeader("Authorization") String token) {
		
		Users actualUsers = tokenService.validateJwtToken(token);
		UsersDTO usersDTO = UsersMapper.MAPPER.mapToUsersDto(actualUsers);
		return usersDTO;
	}

}