package com.manutentioncontrol.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manutentioncontrol.entities.UsersEntity;
import com.manutentioncontrol.repositories.UsersRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	private UsersRepository usersRepository;

	public AuthorizationService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		UsersEntity user = usersRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return user;
	}

}
