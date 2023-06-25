package com.chatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dtoJson.UsersJsonDTO;
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
//
//    @PostMapping("/token")
//    public String token(Authentication authentication) {
//        LOG.debug("Token requested for user: '{}'", authentication.getName());
//        String token = tokenService.generateToken(authentication);
//        LOG.debug("Token granted: {}", token);
//        return token;
//    }
//
//    @PostMapping("/auth/me")
//    public String me(Authentication authentication) {
    //?? interceptor ? puis resortir l'user
//        LOG.debug("Token requested for user: '{}'", authentication.getName());
//        String token = tokenService.generateToken(authentication);
//        LOG.debug("Token granted: {}", token);
//        return token;
//    }
    
    @PostMapping("/auth/register")
    @ResponseBody
    public String register(@RequestBody UsersJsonDTO usersJsonDTO){
    	usersService.registerUser(usersJsonDTO);
    	String token = tokenService.generateToken(usersJsonDTO.getName());
        return token;
    }
    
//    @PostMapping("/auth/login")
//    public String login(Authentication authentication) {
//        LOG.debug("Token requested for user: '{}'", authentication.getName());
//        //String token = tokenService.generateToken(authentication);
//        LOG.debug("Token granted: {}", token);
//        return token;
//    }
        
}