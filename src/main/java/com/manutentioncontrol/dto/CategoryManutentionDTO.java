package com.manutentioncontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoryManutentionDTO {
	
	
	private Integer id;
	
	private Integer userId;
	
	@NotNull(message = "Categoria não pode ser nula")
	@NotBlank(message = "Categoria não pode ficar em branco")
	private String name;

	public CategoryManutentionDTO() {
	}

	public CategoryManutentionDTO(Integer userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
