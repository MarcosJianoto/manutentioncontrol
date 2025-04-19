package com.manutentioncontrol.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutentioncontrol.entities.UsersEntity;
import com.manutentioncontrol.infra.security.TokenService;
import com.manutentioncontrol.repositories.UsersRepository;

import authentication.AuthenticationDTO;
import authentication.LoginResponseDTO;
import authentication.RegisterDTO;
import authentication.UserRole;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	private AuthenticationManager authenticationManager;
	private UsersRepository usersRepository;
	private PasswordEncoder passwordEncoder;
	private TokenService tokenService;

	public AuthenticationController(AuthenticationManager authenticationManager, UsersRepository usersRepository,
			PasswordEncoder passwordEncoder, TokenService tokenService) {
		this.authenticationManager = authenticationManager;
		this.usersRepository = usersRepository;
		this.passwordEncoder = passwordEncoder;
		this.tokenService = tokenService;
	};

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {

		var usernamePassowrd = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassowrd);

		var token = tokenService.generateToken((UsersEntity) auth.getPrincipal());

		return ResponseEntity.ok(new LoginResponseDTO(token));

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
