package com.manutentioncontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutentioncontrol.entities.CategoryManutention;
import com.manutentioncontrol.entities.UsersEntity;


@Repository
public interface CategoryManutentionRepository extends JpaRepository<CategoryManutention, Integer> {

	boolean existsByName(String name);
	
	boolean existsByUserIdAndName(UsersEntity userId, String name);

	CategoryManutention findByName(String name);
	
}
