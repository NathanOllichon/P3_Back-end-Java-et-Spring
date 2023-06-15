package com.chatop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.File;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;

@Entity
@Table(name = "rentals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rentals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "surface")
	private int surface;

	@Column(name = "price")
	private int price;
	
	//URL
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "description")
	private String description;

	//TODO Something ? Key
	@Column(name = "owner_id")
	private String owner_id;
	
	@CreatedDate
	@Column(name = "created_at")
	private String created_at;

	@LastModifiedDate
	@Column(name = "updated_at")
	private String updated_at;
	
}
