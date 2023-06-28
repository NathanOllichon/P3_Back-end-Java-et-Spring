package com.chatop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

//	@Column(name = "rental_id")
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(name="rental_id")
	private Rentals rentals;

//	@Column(name = "user_id")
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(name="user_id")
	private Users user;
	
	@Column(name = "message")
	private String message;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Timestamp created_at;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Timestamp updated_at;
	
}
