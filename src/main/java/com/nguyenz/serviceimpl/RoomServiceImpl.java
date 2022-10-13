package com.nguyenz.serviceimpl;

import com.nguyenz.dto.RoomDTO;
import com.nguyenz.entity.Room;
import com.nguyenz.repository.RoomRepository;
import com.nguyenz.service.RoomService;
import com.nguyenz.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UtilService utilService;

    @Override
    public List<RoomDTO> getAll() {
        List<RoomDTO> roomDTOS = new ArrayList<>();
        List<Room> rooms = roomRepository.getAll();
        for(Room room:rooms){
            roomDTOS.add(utilService.convertToRoomDTO(room));
        }
        return roomDTOS;
    }

    @Override
    public RoomDTO getById(int id) {
        return utilService.convertToRoomDTO(roomRepository.getById(id));
    }

    @Override
    public RoomDTO add(RoomDTO roomDTO) {
        return utilService.convertToRoomDTO(
                roomRepository.save(
                        utilService.convertToRoom(roomDTO)));
    }

    @Override
    public RoomDTO update(RoomDTO roomDTO) {
        return add(roomDTO);
    }

    @Override
    public int delete(int id) {
        return roomRepository.normalDelete(id);
    }

    @Override
    public void hardDelete(int id) {
        roomRepository.delete(utilService.convertToRoom(getById(id)));
    }
}
