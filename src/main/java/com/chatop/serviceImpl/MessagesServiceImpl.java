package com.chatop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.model.Messages;
import com.chatop.model.Rentals;
import com.chatop.model.Users;
import com.chatop.repository.MessagesRepository;
import com.chatop.service.MessagesService;

@Service
public class MessagesServiceImpl implements MessagesService{

    @Autowired
    private MessagesRepository messagesRepository;

    private UsersServiceImpl usersServiceImpl;
    
    private RentalsServiceImpl rentalsServiceImpl;
    
    @Override
	public void createMessage(Long rental_id, Long user_id, String message) {
		Users owner = usersServiceImpl.getUsers(user_id);
		Rentals rentals = rentalsServiceImpl.getRentals(rental_id);

		Messages messageCreated = new Messages(null, rentals, owner, message, null, null);
		
		
        messagesRepository.save(messageCreated);
	}
	
}