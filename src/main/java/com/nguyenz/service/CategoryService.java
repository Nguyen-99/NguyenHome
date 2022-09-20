package com.nguyenz.service;

import java.util.List;

import com.nguyenz.dto.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getAll();
	CategoryDTO getById(int id);
	
	CategoryDTO add(CategoryDTO categoryDTO);
	CategoryDTO update(CategoryDTO categoryDTO);
	void delete(int id);
}
