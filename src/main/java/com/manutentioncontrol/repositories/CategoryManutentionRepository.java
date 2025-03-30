package com.manutentioncontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manutentioncontrol.entities.CategoryManutention;

@Repository
public interface CategoryManutentionRepository extends JpaRepository<CategoryManutention, Integer> {

	boolean existsByName(String name);

	CategoryManutention findByName(String name);
	
}
