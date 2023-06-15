package com.chatop.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.model.Messages;
import com.chatop.repository.MessagesRepository;
import com.chatop.service.MessagesService;

@Service
public class MessagesServiceImpl implements MessagesService{

    @Autowired
    private MessagesRepository messagesRepository;

    @Override
	public void createMessage(Long rental_id, Long user_id, String message) {
		
		String created_at = ""; //Timestamp.;
		String update_at = null;
		
		Messages messageCreated = new Messages(null, rental_id, user_id, message, created_at, update_at);
		
		
        messagesRepository.save(messageCreated);
	}
	
}