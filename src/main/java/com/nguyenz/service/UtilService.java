package com.nguyenz.service;

import com.nguyenz.dto.CategoryDTO;
import com.nguyenz.entity.Category;

public interface UtilService {
    CategoryDTO convertToCategoryDTO(Category category);
    Category convertToCategory(CategoryDTO categoryDTO);
}
