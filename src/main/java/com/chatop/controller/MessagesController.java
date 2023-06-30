package com.chatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dto.MessageRequestDTO;
import com.chatop.dto.MessagesResponseDTO;
import com.chatop.serviceImpl.MessagesServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Messages", description = "Messages route APIs")
@RestController
public class MessagesController {

    @Autowired
    private MessagesServiceImpl messagesService;

	@Operation(summary = "Route for create message data", 
			description = "Route for create a message on database. The response is a DTO with a message result of this request.")
    @PostMapping("/messages")
    public ResponseEntity<MessagesResponseDTO> createMessage(@RequestBody MessageRequestDTO messageRequestDTO) {
    	messagesService.createMessage(messageRequestDTO.getRental_id(), messageRequestDTO.getUser_id(), messageRequestDTO.getMessage());
    	MessagesResponseDTO messagesResponseDTO = new MessagesResponseDTO("Message send with success");
        return new ResponseEntity<>(messagesResponseDTO, HttpStatus.OK);
    }
    
}
