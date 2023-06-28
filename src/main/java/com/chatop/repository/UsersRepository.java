package com.chatop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatop.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    public Users findByEmail(String email);
	
}