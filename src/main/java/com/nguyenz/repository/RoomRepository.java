package com.nguyenz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nguyenz.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
//	@Query(value="select * from Room r where r.category.id = :id")
//	List<Room> getRoomByCategoryId(@Param("id") int id);
}
