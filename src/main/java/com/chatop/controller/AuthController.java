package com.chatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dto.CredentialsJsonDTO;
import com.chatop.dto.TokenDTO;
import com.chatop.dto.UsersDTO;
import com.chatop.dto.UsersJsonDTO;
import com.chatop.mapper.UsersMapper;
import com.chatop.model.Users;
import com.chatop.service.TokenService;
import com.chatop.serviceImpl.UsersServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentification", description = "Authentification route APIs")
@RestController
public class AuthController {

	@Autowired
	private UsersServiceImpl usersService;

	private final TokenService tokenService;

	public AuthController(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	@Operation(summary = "Create a new User, email unique needed", 
			description = "Route for create an user. Email need to be unique ! The response is the security token.")
	@PostMapping("/auth/register")
	@ResponseBody
	public TokenDTO register(@RequestBody UsersJsonDTO usersJsonDTO) {
		usersService.registerUser(usersJsonDTO);
		String token = tokenService.generateToken(usersJsonDTO.getEmail());
		TokenDTO tokenDTO = new TokenDTO(token);
		return tokenDTO;
	}

	@Operation(summary = "Log in route if your user are registered and your credentials are good", 
			description = "Route for log in user. Credentials mail and password needed. The response is the security token.")
	@PostMapping("/auth/login")
	@ResponseBody
	public TokenDTO login(@RequestBody CredentialsJsonDTO credentialsJsonDTO) {
		Users user = usersService.isLoginValid(credentialsJsonDTO.getEmail(), credentialsJsonDTO.getPassword());
		String token = tokenService.generateToken(user.getEmail());
		TokenDTO tokenDTO = new TokenDTO(token);
		return tokenDTO;
	}

	@Operation(summary = "Route for validate your JWT token", 
			description = "Route for validate your token. The response is a DTO with your user informations.")
	@GetMapping("/auth/me")
	@ResponseBody
	public UsersDTO getMe(@RequestHeader("Authorization") String token) {

		Users actualUsers = tokenService.validateJwtToken(token);
		UsersDTO usersDTO = UsersMapper.MAPPER.mapToUsersDto(actualUsers);
		return usersDTO;
	}

}