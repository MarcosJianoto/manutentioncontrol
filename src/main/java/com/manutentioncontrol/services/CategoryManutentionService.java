package com.manutentioncontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.manutentioncontrol.dto.CategoryManutentionDTO;
import com.manutentioncontrol.entities.CategoryManutention;
import com.manutentioncontrol.entities.UsersEntity;
import com.manutentioncontrol.repositories.CategoryManutentionRepository;
import com.manutentioncontrol.repositories.UsersRepository;

@Service
public class CategoryManutentionService {

	@Autowired
	private CategoryManutentionRepository categoryManutentionRepository;
	private UsersRepository usersRepository;

	public CategoryManutentionService(CategoryManutentionRepository categoryManutentionRepository,
			UsersRepository usersRepository) {
		this.categoryManutentionRepository = categoryManutentionRepository;
		this.usersRepository = usersRepository;
	}

	public void createCategory(CategoryManutentionDTO categoryManutentionDTO) {

		UsersEntity user = usersRepository.findById(categoryManutentionDTO.getUserId())
				.orElseThrow(() -> new IllegalArgumentException("user not found"));

		CategoryManutention categoryManutention = new CategoryManutention(user, categoryManutentionDTO.getName());
		categoryManutentionRepository.save(categoryManutention);
	}

	public CategoryManutention getCategoryById(Integer id) {
		return categoryManutentionRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada!"));
	}

	public List<CategoryManutention> getAllCategories() {
		return categoryManutentionRepository.findAll();
	}

	public void updateCategory(Integer id, CategoryManutentionDTO categoryManutentionDTO) {
		CategoryManutention categoryManutention = getCategoryById(id);
		categoryManutention.setName(categoryManutentionDTO.getName());
		categoryManutentionRepository.save(categoryManutention);
	}

	public void deleteCategory(Integer id) {
		if (!categoryManutentionRepository.existsById(id)) {
			throw new IllegalArgumentException("Categoria não encontrada para exclusão!");
		}
		categoryManutentionRepository.deleteById(id);
	}

}
