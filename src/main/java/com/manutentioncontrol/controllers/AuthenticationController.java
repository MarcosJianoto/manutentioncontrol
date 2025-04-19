package com.manutentioncontrol.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder passwordEncoder;

	public AuthenticationController(AuthenticationManager authenticationManager, UsersRepository usersRepository,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.usersRepository = usersRepository;
		this.passwordEncoder = passwordEncoder;
	};

	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody @Valid AuthenticationDTO data) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.email(), data.password()));
			return ResponseEntity.ok().build();
		} catch (AuthenticationException ex) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
		if (this.usersRepository.findByEmail(data.email()) != null)
			return ResponseEntity.badRequest().build();

		String encryptedPassword = passwordEncoder.encode(data.password());

		UserRole userRole = UserRole.valueOf(data.role().toUpperCase());
		UsersEntity user = new UsersEntity(data.email(), encryptedPassword, userRole);

		this.usersRepository.save(user);

		return ResponseEntity.ok().build();

	}

}
