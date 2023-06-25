package com.chatop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chatop.dtoJson.UsersJsonDTO;
import com.chatop.mapper.UsersMapper;
import com.chatop.model.Users;
import com.chatop.model.UsersDTO;
import com.chatop.repository.UsersRepository;
import com.chatop.service.UsersService;
 
@Service
public class UsersServiceImpl implements UsersService {
	
    @Autowired
    private UsersRepository usersRepository;
	
    @Override
	public Users getUsers(final Long id) {
    	System.out.println(id);
    	System.out.println(usersRepository.findById(id));
    	Users user = usersRepository.findById(id).get();
    	System.out.println(user.toString());
    	System.out.println("userRepo " + usersRepository.findById(id).get().toString());
    	//UsersDTO userDTO = UsersMapper.MAPPER.mapToUsersDto(user);
		//System.out.println(userDTO.getEmail() + " " + userDTO.getName());
    	return user;
	}
    
    @Override
    @Transactional
	public void registerUser(UsersJsonDTO usersJsonDTO) {
    	//Long id = (long) 1;
    	Users usersCreated = new Users(null, usersJsonDTO.getEmail(), usersJsonDTO.getName(), usersJsonDTO.getPassword(), null, null);
        System.out.println("usersJsonDTO => " + usersJsonDTO);
        System.out.println("Users => id => " + usersCreated.getId() + " email => " + usersCreated.getEmail() + " name => " + usersCreated.getName() + " password => "+ usersCreated.getPassword() + " created => " + usersCreated.getCreated_at() + " update => " + usersCreated.getUpdated_at());
    	usersRepository.save(usersCreated);
    }
    
}