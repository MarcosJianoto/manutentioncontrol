package com.manutentioncontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutentioncontrol.entities.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {

	boolean existsByEmail(String email);

	UsersEntity findByEmail(String email);

}
