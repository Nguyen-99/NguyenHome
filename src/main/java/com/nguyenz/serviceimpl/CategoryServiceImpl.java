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
	private UtilServiceImpl utilServiceImpl;
	
	@Override
	public List<CategoryDTO> getAll() {
		List<Category> categories = categoryRepository.getAll();
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for(Category category:categories) {
			CategoryDTO categoryDTO = utilServiceImpl.convertToCategoryDTO(category);
			categoryDTOs.add(categoryDTO);
		}
		return categoryDTOs;
	}

	@Override
	public CategoryDTO getById(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		if(category == null){
			return null;
		}
		return utilServiceImpl.convertToCategoryDTO(category);
	}

	@Override
	public CategoryDTO add(CategoryDTO categoryDTO) {
		Category category = utilServiceImpl.convertToCategory(categoryDTO);
		category.setActive(true);
		return utilServiceImpl.convertToCategoryDTO(categoryRepository.save(category));
	}

	@Override
	public CategoryDTO update(CategoryDTO categoryDTO) {
		return add(categoryDTO);
	}

	@Override
	public void hardDelete(int id) {
		Category category = utilServiceImpl.convertToCategory(getById(id));
		categoryRepository.delete(category);
	}

	@Override
	public int delete(int id) {
		return categoryRepository.normalDelete(id);
	}
}
