package com.chatop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Timestamp created_at;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Timestamp updated_at;
	
}
