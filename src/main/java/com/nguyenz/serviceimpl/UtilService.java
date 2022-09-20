package com.nguyenz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenz.dto.CategoryDTO;
import com.nguyenz.entity.Category;
import com.nguyenz.repository.RoomRepository;

@Service
public class UtilService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public CategoryDTO convertToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}
	
	public Category convertToCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
//		category.setRoomList(roomRepository.getRoomByCategoryId(categoryDTO.getId()));
		return category;
	}
}
