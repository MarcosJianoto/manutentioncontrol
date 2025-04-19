package com.manutentioncontrol.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutentioncontrol.entities.UsersEntity;
import com.manutentioncontrol.repositories.UsersRepository;

import authentication.AuthenticationDTO;
import authentication.RegisterDTO;
import authentication.UserRole;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	private AuthenticationManager authenticationManager;
	private UsersRepository usersRepository;

	public AuthenticationController(AuthenticationManager authenticationManager, UsersRepository usersRepository) {
		this.authenticationManager = authenticationManager;
		this.usersRepository = usersRepository;
	};

	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
		if (this.usersRepository.findByEmail(data.email()) != null)
			return ResponseEntity.badRequest().build();

		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

		UserRole userRole = UserRole.valueOf(data.role().toUpperCase());
		UsersEntity user = new UsersEntity(data.email(), encryptedPassword, userRole);

		this.usersRepository.save(user);

		return ResponseEntity.ok().build();

	}

}
