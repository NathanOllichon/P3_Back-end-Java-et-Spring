package com.chatop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.chatop.model.Rentals;

public interface RentalsRepository extends JpaRepository<Rentals, Long> {

}