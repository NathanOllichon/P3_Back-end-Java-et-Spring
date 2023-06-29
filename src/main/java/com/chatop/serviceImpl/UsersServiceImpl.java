package com.chatop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chatop.dto.UsersJsonDTO;
import com.chatop.model.Users;
import com.chatop.repository.UsersRepository;
import com.chatop.service.UsersService;
import com.nimbusds.jose.util.Base64;
 
@Service
public class UsersServiceImpl implements UsersService {
	
    @Autowired
    private UsersRepository usersRepository;
	
    @Override
	public Users getUsers(final Long id) {
    	Users user = usersRepository.findById(id).get();
    	return user;
	}
    
    @Override
	public void registerUser(UsersJsonDTO usersJsonDTO) {
    	String encodedString = java.util.Base64.getEncoder().encodeToString(usersJsonDTO.getPassword().getBytes());
    	Users usersCreated = new Users(null, usersJsonDTO.getEmail(), usersJsonDTO.getName(), encodedString, null, null);
    	usersRepository.save(usersCreated);
    }
    
    @Override
	public Users isLoginValid(String mail, String password) {
    	Users user = usersRepository.findByEmail(mail);
    	String encodedString = java.util.Base64.getEncoder().encodeToString(password.getBytes());
    	if(user.getPassword().equals(encodedString)) {
    		return user;
    	}
    	return null;
	}
    
}