package com.blog.app.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.payloads.API_Response;
import com.blog.app.payloads.CategoryDTO;
import com.blog.app.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

//	Create
	@PostMapping("/create")
	public ResponseEntity<CategoryDTO> crateCategory(@Valid @RequestBody CategoryDTO categoryDto) {
		CategoryDTO createdCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDTO>(createdCategory, HttpStatus.CREATED);

	}

//	update

	@PutMapping("/update/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDto,
			@PathVariable Integer categoryId) {
		CategoryDTO updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDTO>(updatedCategory, HttpStatus.OK);
	}
//	delete

	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<API_Response> deleteCategory(@PathVariable Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<API_Response>(new API_Response("Category deleted successfully.", true),
				HttpStatus.OK);

	}

//	get
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer categoryId) {
		CategoryDTO getCategory = this.categoryService.getCategory(categoryId);
		return new ResponseEntity<CategoryDTO>(getCategory, HttpStatus.OK);
	}

	@GetMapping("/getAllCategories")
	public ResponseEntity<List<CategoryDTO>> getAllCategories() {
		List<CategoryDTO> allCategories = this.categoryService.getCategories();
		return new ResponseEntity<List<CategoryDTO>>(allCategories, HttpStatus.FOUND);
	}
}
