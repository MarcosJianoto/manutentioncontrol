package com.manutentioncontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manutentioncontrol.dto.UsersDTO;
import com.manutentioncontrol.services.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersControllers {

	@Autowired
	private UsersService usersService;

	public UsersControllers(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping
	public ResponseEntity<String> createUser(@Valid @RequestBody UsersDTO usersDTO) {
		usersService.createUser(usersDTO);
		return ResponseEntity.ok("Usuário criado com sucesso!");
	}

	@GetMapping("{id}")
	public ResponseEntity<UsersDTO> getUser(@PathVariable Integer id) {
		return ResponseEntity.ok(usersService.getUser(id));
	}

	@GetMapping
	public ResponseEntity<List<UsersDTO>> getAllUsers() {
		return ResponseEntity.ok(usersService.getAllUsers());
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Integer id, @Valid @RequestBody UsersDTO usersDTO) {
		usersService.editUser(id, usersDTO);
		return ResponseEntity.ok("Usuário atualizado com sucesso!");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		usersService.deleteUser(id);
		return ResponseEntity.ok("Usuário deletado com sucesso!");
	}
}
