package com.nguyenz.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenz.dto.CategoryDTO;
import com.nguyenz.entity.Category;
import com.nguyenz.repository.CategoryRepository;
import com.nguyenz.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UtilService utilService;
	
	@Override
	public List<CategoryDTO> getAll() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for(Category category:categories) {
			CategoryDTO categoryDTO = utilService.convertToCategoryDTO(category);
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}

	@Override
	public CategoryDTO getById(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		return utilService.convertToCategoryDTO(category);
	}

	@Override
	public CategoryDTO add(CategoryDTO categoryDTO) {
		Category category = utilService.convertToCategory(categoryDTO);
		return utilService.convertToCategoryDTO(categoryRepository.save(category));
	}

	@Override
	public CategoryDTO update(CategoryDTO categoryDTO) {
		return add(categoryDTO);
	}

	@Override
	public void delete(int id) {
		Category category = utilService.convertToCategory(getById(id));
		categoryRepository.delete(category);
	}

}