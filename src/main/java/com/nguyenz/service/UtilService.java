package com.nguyenz.service;

import com.nguyenz.dto.CategoryDTO;
import com.nguyenz.dto.RoomDTO;
import com.nguyenz.entity.Category;
import com.nguyenz.entity.Room;

import java.util.Date;

public interface UtilService {
    CategoryDTO convertToCategoryDTO(Category category);
    Category convertToCategory(CategoryDTO categoryDTO);

    RoomDTO convertToRoomDTO(Room room);
    Room convertToRoom(RoomDTO roomDTO);

    String convertDateToString(Date date, String format);
    Date convertStringToDate(String sDate,String format);
}
