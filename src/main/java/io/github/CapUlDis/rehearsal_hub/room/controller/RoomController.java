package io.github.CapUlDis.rehearsal_hub.room.controller;

import io.github.CapUlDis.rehearsal_hub.room.dto.RoomCreateDto;
import io.github.CapUlDis.rehearsal_hub.room.dto.RoomRsDto;
import io.github.CapUlDis.rehearsal_hub.room.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getALlRooms() {
        return "all rooms";
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomRsDto createRoom(@RequestBody RoomCreateDto dto) {
        return service.createRoom(dto);
    }
}
