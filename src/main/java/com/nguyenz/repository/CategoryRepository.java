package com.nguyenz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenz.entity.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value="select c from Category c where c.active = 1")
    List<Category> getAll();

    @Query(value = "update c set c.active=0 where c.id = ?1 ")
    Category normalDelete(int id);
}
