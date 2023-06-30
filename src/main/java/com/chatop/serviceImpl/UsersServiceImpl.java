package com.chatop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.chatop.dto.UsersJsonDTO;
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
	public void registerUser(UsersJsonDTO usersJsonDTO) {
    	
    	String password_hash = BCrypt.hashpw(usersJsonDTO.getPassword(), BCrypt.gensalt());
    	Users usersCreated = new Users(null, usersJsonDTO.getEmail(), usersJsonDTO.getName(), password_hash, null, null);
    	usersRepository.save(usersCreated);
    }
    
    @Override
	public Users isLoginValid(String mail, String password) {
    	Users user = usersRepository.findByEmail(mail);

    	if(BCrypt.checkpw(password, user.getPassword())) {
    		return user;
    	}
    	return null;
	}
    
}
