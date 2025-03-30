package com.manutentioncontrol.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "category_manutention")
public class CategoryManutention {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
	@SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersEntity userId;

	@Column(name = "name")
	private String name;

	public CategoryManutention() {
		super();
	}

	public CategoryManutention(UsersEntity userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsersEntity getUserId() {
		return userId;
	}

	public void setUserIdd(UsersEntity userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
