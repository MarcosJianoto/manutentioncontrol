package com.manutentioncontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manutentioncontrol.dto.UsersDTO;
import com.manutentioncontrol.entities.UserRole;
import com.manutentioncontrol.entities.UsersEntity;
import com.manutentioncontrol.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	public void blankToNull(UsersDTO user) {
		if (user.getEmail() != null || user.getPassword() != null) {
			String userEmailTrim = user.getEmail().trim();
			String userPasswordTrim = user.getPassword().trim();
			if (userEmailTrim.isBlank() || userEmailTrim.isEmpty()) {
				user.setEmail(null);
			}
			if (userPasswordTrim.isBlank() || userPasswordTrim.isEmpty()) {
				user.setPassword(null);
			}
		}
	}

	public void createUser(UsersDTO userDTO) {
		blankToNull(userDTO);

		if (usersRepository.existsByEmail(userDTO.getEmail())) {
			throw new IllegalArgumentException("Email already in use.");
		}
		UsersEntity user = new UsersEntity(userDTO.getEmail(), userDTO.getPassword(), UserRole.USER);
		usersRepository.save(user);
	}

	public UsersEntity findUser(Integer id) {
		return usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found "));
	}

	public void editUser(Integer id, UsersDTO userDTO) {

		blankToNull(userDTO);

		UsersEntity user = findUser(id);
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());

		usersRepository.save(user);

	}

	public UsersDTO getUser(Integer id) {
		UsersEntity user = findUser(id);
		return new UsersDTO(user.getId(), user.getEmail(), user.getPassword());
	}

	public List<UsersDTO> getAllUsers() {
		return usersRepository.findAll().stream()
				.map(user -> new UsersDTO(user.getId(), user.getEmail(), user.getPassword())).toList();
	}

	public void deleteUser(Integer id) {
		try {
			if (!usersRepository.existsById(id)) {
				throw new IllegalArgumentException("User not found");
			}
			usersRepository.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Error deleting user" + e.getMessage());
		}

		System.out.println();
	}
}
