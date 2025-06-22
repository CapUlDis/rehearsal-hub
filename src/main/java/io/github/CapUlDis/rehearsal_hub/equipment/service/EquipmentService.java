package io.github.CapUlDis.rehearsal_hub.equipment.service;

import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentCreateDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentRsDto;
import io.github.CapUlDis.rehearsal_hub.equipment.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {
    private final EquipmentRepository repository;

    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    public EquipmentRsDto createEquipment(EquipmentCreateDto dto) {
        return repository.save(dto);
    }
}
