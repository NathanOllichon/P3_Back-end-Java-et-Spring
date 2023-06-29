package com.chatop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chatop.dto.MessagesDTO;
import com.chatop.model.Messages;

@Mapper
public interface MessagesMapper {

	MessagesMapper MAPPER = Mappers.getMapper(MessagesMapper.class);

    MessagesDTO mapToMessagesDto(Messages messages);

    Messages mapToMessages(MessagesDTO messagesDto);
    
}