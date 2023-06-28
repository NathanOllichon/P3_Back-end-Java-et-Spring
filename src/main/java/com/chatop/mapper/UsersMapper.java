package com.chatop.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chatop.model.Users;
import com.chatop.model.UsersDTO;

@Mapper
public interface UsersMapper {

	UsersMapper MAPPER = Mappers.getMapper(UsersMapper.class);

	UsersDTO mapToUsersDto(Users user);

	Users mapToUsers(UsersDTO usersDTO);
    
}