package io.github.CapUlDis.rehearsal_hub.equipment.controllers;

import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentCreateDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentRsDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public EquipmentRsDto createEquipment(@RequestBody EquipmentCreateDto dto) {
        return EquipmentRsDto.builder()
                .id(UUID.randomUUID())
                .name(dto.getName())
                .type(dto.getType())
                .build();
    }
}
