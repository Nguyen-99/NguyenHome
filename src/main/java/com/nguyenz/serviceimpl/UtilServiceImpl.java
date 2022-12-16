package com.nguyenz.serviceimpl;

import com.nguyenz.dto.RoomDTO;
import com.nguyenz.entity.Room;
import com.nguyenz.repository.CategoryRepository;
import com.nguyenz.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenz.dto.CategoryDTO;
import com.nguyenz.entity.Category;
import com.nguyenz.repository.RoomRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UtilServiceImpl implements UtilService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDTO convertToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());
		return categoryDTO;
	}

	@Override
	public Category convertToCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		category.setActive(true);
		category.setRoomList(roomRepository.getRoomByCategoryId(categoryDTO.getId()));
		return category;
	}

	@Override
	public RoomDTO convertToRoomDTO(Room room) {
		RoomDTO roomDTO = new RoomDTO();
		roomDTO.setId(room.getId());
		roomDTO.setName(room.getName());
		roomDTO.setArea(room.getArea());
		roomDTO.setAddress(room.getAddress());
		roomDTO.setPrice(room.getPrice());
		roomDTO.setImage(room.getImage());
		roomDTO.setDescription(room.getDescription());
		if(room.getPostDate() != null){
			String sPostDate = convertDateToString(room.getPostDate(),"dd/MM/yyyy HH:mm:ss");
			roomDTO.setPostDate(sPostDate);
		}
		if(room.getUpdateDate() != null){
			String sUpdateDate = convertDateToString(room.getUpdateDate(),"dd/MM/yyyy HH:mm:ss");
			roomDTO.setUpdateDate(sUpdateDate);
		}
		if(room.getCategory() != null){
			roomDTO.setCategoryId(room.getCategory().getId());
		}
		return roomDTO;
	}

	@Override
	public Room convertToRoom(RoomDTO roomDTO) {
		Room room = new Room();
		room.setId(roomDTO.getId());
		room.setName(roomDTO.getName());
		room.setArea(roomDTO.getArea());
		room.setAddress(roomDTO.getAddress());
		room.setPrice(roomDTO.getPrice());
		room.setImage(roomDTO.getImage());
		room.setDescription(roomDTO.getDescription());
		if(roomDTO.getPostDate() != null){
			Date postDate = convertStringToDate(roomDTO.getPostDate(),"dd/MM/yyyy HH:mm:ss");
			room.setPostDate(postDate);
		}
		if(roomDTO.getUpdateDate() != null){
			Date updateDate = convertStringToDate(roomDTO.getUpdateDate(),"dd/MM/yyyy HH:mm:ss");
			room.setUpdateDate(updateDate);
		}
		room.setActive(true);
		room.setCategory(categoryRepository.getById(roomDTO.getCategoryId()));
		return room;
	}

	@Override
	public String convertDateToString(Date date,String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		String sDate = dateFormat.format(date);
		return sDate;
	}

	@Override
	public Date convertStringToDate(String sDate,String format){
		Date date = null;
		DateFormat dateFormat = new SimpleDateFormat(format);
		try {
			date = dateFormat.parse(sDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}
}
