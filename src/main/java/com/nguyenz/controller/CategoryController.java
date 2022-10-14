package com.nguyenz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nguyenz.dto.CategoryDTO;
import com.nguyenz.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getAll")
	public List<CategoryDTO> getAll(){
		return categoryService.getAll();
	}

	@GetMapping("/getById/{id}")
	public CategoryDTO getById(@PathVariable int id){
		return categoryService.getById(id);
	}

	@PostMapping("/add")
	public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.add(categoryDTO);
	}

	@PutMapping("/update")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO){
		return categoryService.update(categoryDTO);
	}

	@PutMapping("/delete/{id}")
	public void deleteCategory(@PathVariable int id){
		categoryService.delete(id);
	}

}
