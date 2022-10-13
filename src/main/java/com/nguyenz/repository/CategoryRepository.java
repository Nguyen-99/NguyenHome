package com.nguyenz.repository;

import com.nguyenz.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenz.entity.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value="select c from Category c where c.active = true")
    List<Category> getAll();

    @Query(value = "update Category c set c.active=false where c.id = ?1 ")
    @Modifying
    @Transactional
    int normalDelete(int id);


    @Query(value = "select c from Category c where c.active = true and c.id = ?1")
    Category getById(int categoryId);

}
