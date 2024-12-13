package com.blog.app.services;

import java.util.List;

import com.blog.app.payloads.CategoryDTO;

public interface CategoryService {

	// Create
	CategoryDTO createCategory(CategoryDTO categoryDto);

	// Update
	CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId);

	// Delete
	void deleteCategory(Integer categoryId);

	// Get
	CategoryDTO getCategory(Integer categoryId);

	// GetAll
	List<CategoryDTO> getCategories();

}