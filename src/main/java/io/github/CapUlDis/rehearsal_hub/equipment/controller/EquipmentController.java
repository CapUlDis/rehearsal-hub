package io.github.CapUlDis.rehearsal_hub.equipment.controller;

import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentCreateDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentRsDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentsRsDto;
import io.github.CapUlDis.rehearsal_hub.equipment.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    private final EquipmentService service;

    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public EquipmentRsDto createEquipment(@RequestBody EquipmentCreateDto dto) {
        return service.createEquipment(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable("id") String id) {
        service.deleteEquipment(id);
    }

    @GetMapping("")
    public EquipmentsRsDto getAllEquipments() {
        return service.getAllEquipments();
    }
}
