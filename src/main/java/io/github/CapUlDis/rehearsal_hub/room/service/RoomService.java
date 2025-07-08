package io.github.CapUlDis.rehearsal_hub.room.service;

import io.github.CapUlDis.rehearsal_hub.equipment.repository.EquipmentRepository;
import io.github.CapUlDis.rehearsal_hub.room.dto.RoomCreateDto;
import io.github.CapUlDis.rehearsal_hub.room.dto.RoomRsDto;
import io.github.CapUlDis.rehearsal_hub.room.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final EquipmentRepository equipmentRepository;

    public RoomService(RoomRepository roomRepository, EquipmentRepository equipmentRepository) {
        this.roomRepository = roomRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Transactional
    public RoomRsDto createRoom(RoomCreateDto dto) {
        var room = roomRepository.save(dto);

        if (dto.getEquipmentIds() != null && !dto.getEquipmentIds().isEmpty()) {
            var equipments = equipmentRepository.assignToRoom(dto.getEquipmentIds(), room.getId());
            room.setEquipments(equipments);
        }

        return room;
    }

    public void deleteRoom(String id) {
        roomRepository.delete(id);
    }

    public RoomRsDto findRoomById(String id) {
        return roomRepository.findById(id);
    }
}
