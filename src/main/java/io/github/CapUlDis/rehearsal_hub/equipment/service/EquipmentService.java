package io.github.CapUlDis.rehearsal_hub.equipment.service;

import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentCreateDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentRsDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentsRsDto;
import io.github.CapUlDis.rehearsal_hub.equipment.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public EquipmentRsDto createEquipment(EquipmentCreateDto dto) {
        return equipmentRepository.save(dto);
    }

    public void deleteEquipment(String id) {
        equipmentRepository.delete(id);
    }

    public EquipmentsRsDto getAllEquipments() {
        return EquipmentsRsDto.builder()
                .items(equipmentRepository.getAll())
                .build();
    }
}
