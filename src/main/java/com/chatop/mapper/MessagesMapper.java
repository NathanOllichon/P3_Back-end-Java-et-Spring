package com.chatop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chatop.model.Messages;
import com.chatop.model.MessagesDTO;

@Mapper
public interface MessagesMapper {

	MessagesMapper MAPPER = Mappers.getMapper(MessagesMapper.class);

	//Maybe ? TODO https://stackoverflow.com/questions/45482677/java-unmapped-target-properties
    MessagesDTO mapToMessagesDto(Messages messages);

    Messages mapToMessages(MessagesDTO messagesDto);
    
}