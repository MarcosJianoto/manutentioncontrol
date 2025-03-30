package com.manutentioncontrol.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsersDTO {
	private Integer id;

	@NotNull(message = "Senha não pode ser nula")
	@NotBlank(message = "Senha não pode ficar em branco")
	@Email(message = "Formato de e-mail inválido")
	private String email;

	@NotNull(message = "Senha não pode ser nula")
	@NotBlank(message = "Senha não pode ficar em branco")
	@Size(min = 8, message = "Senha precisa ter no mínimo 8 caracteres")
	private String password;

	public UsersDTO() {

	}

	public UsersDTO(Integer id, String email, String password) {
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
