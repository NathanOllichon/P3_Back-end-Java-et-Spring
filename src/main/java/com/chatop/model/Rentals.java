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

	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(name="owner_id")
	private Users owner;
	
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

	//@Column(name = "owner_id")
	//TODO Something ? Key
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "owner_id", referencedColumnName = "id")
	

	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Timestamp created_at;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Timestamp updated_at;
	
}
