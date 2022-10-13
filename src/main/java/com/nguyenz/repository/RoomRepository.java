package com.nguyenz.repository;

import com.nguyenz.entity.Category;
import com.nguyenz.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Query(value="select r from Room r where r.category.id = ?1 and r.active = true")
	List<Room> getRoomByCategoryId(int categoryId);

	@Query(value = "select r.category from Room r where r.id = ?1")
	Category getCategoryByRoomId(int roomId);

	@Query(value = "select r from Room r where r.active = true")
	List<Room> getAll();

	@Query(value = "select r from Room r where r.active = true and r.id = ?1")
	Room getById(int roomId);

	@Query(value = "update Room r set r.active=false where r.id = ?1 ")
	@Modifying
	@Transactional
	int normalDelete(int id);

}
