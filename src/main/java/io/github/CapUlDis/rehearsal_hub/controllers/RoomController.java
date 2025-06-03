package io.github.CapUlDis.rehearsal_hub.controllers;

import io.github.CapUlDis.rehearsal_hub.dto.RoomCreateDto;
import io.github.CapUlDis.rehearsal_hub.dto.RoomRsDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @GetMapping("/all")
    public String getALlRooms() {
        return "all rooms";
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomRsDto createRoom(@RequestBody RoomCreateDto dto) {
        return RoomRsDto.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .address(dto.getAddress())
                .costPerHour(dto.getCostPerHour())
                .build();
    }
}
