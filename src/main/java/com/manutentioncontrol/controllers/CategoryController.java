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

import com.manutentioncontrol.dto.CategoryManutentionDTO;
import com.manutentioncontrol.entities.CategoryManutention;
import com.manutentioncontrol.services.CategoryManutentionService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryManutentionService categoryManutentionService;

	public CategoryController(CategoryManutentionService categoryManutentionService) {
		this.categoryManutentionService = categoryManutentionService;
	}

	@PostMapping
	public ResponseEntity<String> createCategory(@RequestBody CategoryManutentionDTO categoryManutentionDTO) {
		categoryManutentionService.createCategory(categoryManutentionDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryManutention> getCategoryById(@PathVariable Integer id) {
		CategoryManutention category = categoryManutentionService.getCategoryById(id);
		return ResponseEntity.ok(category);
	}

	@GetMapping
	public ResponseEntity<List<CategoryManutention>> getAllCategories() {
		List<CategoryManutention> categories = categoryManutentionService.getAllCategories();
		return ResponseEntity.ok(categories);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable Integer id,
			@RequestBody CategoryManutentionDTO categoryManutentionDTO) {
		categoryManutentionService.updateCategory(id, categoryManutentionDTO);
		return ResponseEntity.ok("Categoria atualizada com sucesso!");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
		categoryManutentionService.deleteCategory(id);
		return ResponseEntity.ok("Categoria deletada com sucesso!");
	}

}
