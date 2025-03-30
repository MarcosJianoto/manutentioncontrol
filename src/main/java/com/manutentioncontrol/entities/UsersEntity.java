package com.manutentioncontrol.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
	@SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 1)
	private Integer id;

	
	@Column(name = "email", nullable = false)
	private String email;

	
	@Column(name = "password", nullable = false)
	private String password;

	public UsersEntity() {
	}
	
	
	public UsersEntity(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UsersEntity(Integer id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
