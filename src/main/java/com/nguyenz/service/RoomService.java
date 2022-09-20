package com.nguyenz.service;

import java.util.List;

import com.nguyenz.dto.RoomDTO;

public interface RoomService {
	List<RoomDTO> getAll();
	RoomDTO getById(int id);
	
	RoomDTO add(RoomDTO roomDTO);
	RoomDTO update(RoomDTO roomDTO);
	void delete(int id);
}
