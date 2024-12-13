package com.blog.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.entities.Category;
import com.blog.app.exceptions.ResourceNotFoundException;
import com.blog.app.payloads.CategoryDTO;
import com.blog.app.repositories.CategoryRepo;
import com.blog.app.services.CategoryService;

@Service
public class CategorySeerviceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category savedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(savedCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));

		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updatedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category Id", categoryId));

		this.categoryRepo.delete(category);
	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
		return this.modelMapper.map(category, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getCategories() {
		List<Category> categoryList = this.categoryRepo.findAll();
		List<CategoryDTO> collectedCategories = categoryList.stream()
				.map(category-> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
		return collectedCategories;
	}

}
