package io.github.CapUlDis.rehearsal_hub.room.controller;

import io.github.CapUlDis.rehearsal_hub.room.dto.RoomCreateDto;
import io.github.CapUlDis.rehearsal_hub.room.dto.RoomRsDto;
import io.github.CapUlDis.rehearsal_hub.room.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/all")
    public String getALlRooms() {
        return "all rooms";
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomRsDto createRoom(@RequestBody RoomCreateDto dto) {
        return roomService.createRoom(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable("id") String id) {
        roomService.deleteRoom(id);
    }

    @GetMapping("/{id}")
    public RoomRsDto getRoom(@PathVariable("id") String id) {
        return roomService.findRoomById(id);
    }
}
