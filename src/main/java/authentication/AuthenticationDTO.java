package authentication;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
		
		
		@Email(message = "E-mail inválido") @NotBlank(message = "O e-mail é obrigatório") String email,

		@NotBlank(message = "A senha é obrigatória") String password) {

}
