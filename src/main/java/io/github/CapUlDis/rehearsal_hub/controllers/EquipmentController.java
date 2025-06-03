package io.github.CapUlDis.rehearsal_hub.controllers;

import io.github.CapUlDis.rehearsal_hub.dto.EquipmentCreateDto;
import io.github.CapUlDis.rehearsal_hub.dto.EquipmentRsDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public EquipmentRsDto createRoom(@RequestBody EquipmentCreateDto dto) {
        return EquipmentRsDto.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .type(dto.getType())
                .build();
    }
}
