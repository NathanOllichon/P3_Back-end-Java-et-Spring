package com.chatop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chatop.dtoModificate.UsersJsonDTO;
import com.chatop.model.Users;
import com.chatop.repository.UsersRepository;
import com.chatop.service.UsersService;
 
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
    @Transactional
	public void registerUser(UsersJsonDTO usersJsonDTO) {
    	Users usersCreated = new Users(null, usersJsonDTO.getEmail(), usersJsonDTO.getName(), usersJsonDTO.getPassword(), null, null);
    	usersRepository.save(usersCreated);
    }
    
    @Override
	public Users isLoginValid(String mail, String password) {
    	Users user = usersRepository.findByEmail(mail);
    	if(user.getPassword().equals(password)) {
    		return user;
    	}
    	return null;
	}
    
}