package com.chatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.dtoModificate.MessageRequestDTO;
import com.chatop.dtoModificate.MessagesResponseDTO;
import com.chatop.serviceImpl.MessagesServiceImpl;


@RestController
public class MessagesController {

    @Autowired
    private MessagesServiceImpl messagesService;

    @PostMapping("/messages")
    public ResponseEntity<MessagesResponseDTO> createMessage(@RequestBody MessageRequestDTO messageRequestDTO) {
    	messagesService.createMessage(messageRequestDTO.getRental_id(), messageRequestDTO.getUser_id(), messageRequestDTO.getMessage());
    	MessagesResponseDTO messagesResponseDTO = new MessagesResponseDTO("Message send with success");
        return new ResponseEntity<>(messagesResponseDTO, HttpStatus.OK);
    }
    
}
