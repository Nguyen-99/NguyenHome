package com.nguyenz.repository;

import com.nguyenz.entity.Category;
import com.nguyenz.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Query(value="select r from Room r where r.category.id = ?1")
	List<Room> getRoomByCategoryId(int categoryId);

	@Query(value = "select r.category from Room r where r.id = ?1")
	Category getCategoryByRoomId(int roomId);
}
