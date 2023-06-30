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
    	//String salt = BCrypt.gensalt();
    	//String password_hash = BCrypt.hashpw(usersJsonDTO.getPassword(), salt);
    	
    	String password_hash = BCrypt.hashpw(usersJsonDTO.getPassword(), BCrypt.gensalt());

    	
//    	String encodedString = java.util.Base64.getEncoder().encodeToString(usersJsonDTO.getPassword().getBytes());
//    	Users usersCreated = new Users(null, usersJsonDTO.getEmail(), usersJsonDTO.getName(), encodedString, null, null);
    	Users usersCreated = new Users(null, usersJsonDTO.getEmail(), usersJsonDTO.getName(), password_hash, null, null);
    	
    	usersRepository.save(usersCreated);
    }
    
    @Override
	public Users isLoginValid(String mail, String password) {
    	Users user = usersRepository.findByEmail(mail);
    	//String encodedString = java.util.Base64.getEncoder().encodeToString(password.getBytes());

    	//String password_hash = BCrypt.hashpw(password, BCrypt.gensalt());

//    	if(user.getPassword().equals(password_hash)) {
    	if(BCrypt.checkpw(password, user.getPassword())) {
    		return user;
    	}
    	return null;
	}
    
}