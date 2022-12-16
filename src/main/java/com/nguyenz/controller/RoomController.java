package com.nguyenz.controller;

import com.nguyenz.dto.RoomDTO;
import com.nguyenz.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/getAll")
    public List<RoomDTO> getAll(){
        return roomService.getAll();
    }

    @GetMapping("/getById/{id}")
    public RoomDTO getById(@PathVariable int id){
        return roomService.getById(id);
    }

    @PostMapping("/add")
    public RoomDTO addRoom(@RequestBody RoomDTO roomDTO){
        return roomService.add(roomDTO);
    }

    @PutMapping("/update")
    public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO){
        return roomService.update(roomDTO);
    }

    @GetMapping("/delete/{id}")
    public int deleteRoom(@PathVariable int id){
        return roomService.delete(id);
    }
}
