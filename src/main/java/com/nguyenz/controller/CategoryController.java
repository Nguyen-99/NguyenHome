package com.nguyenz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenz.dto.CategoryDTO;
import com.nguyenz.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/add")
	public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO) {
		return categoryService.add(categoryDTO);
	}
	
	@GetMapping("/get-all")
	public List<CategoryDTO> getAll(){
		return categoryService.getAll();
	}
}
