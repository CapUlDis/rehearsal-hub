package io.github.CapUlDis.rehearsal_hub.room.service;

import io.github.CapUlDis.rehearsal_hub.room.dto.RoomCreateDto;
import io.github.CapUlDis.rehearsal_hub.room.dto.RoomRsDto;
import io.github.CapUlDis.rehearsal_hub.room.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public RoomRsDto createRoom(RoomCreateDto dto) {
        return repository.save(dto);
    }
}
