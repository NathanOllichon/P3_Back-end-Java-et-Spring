package com.chatop.repository;


import org.springframework.data.repository.CrudRepository;

import com.chatop.model.Messages;

public interface MessagesRepository extends CrudRepository<Messages, Integer> {

}