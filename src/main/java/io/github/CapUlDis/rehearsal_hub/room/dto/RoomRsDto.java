package io.github.CapUlDis.rehearsal_hub.room.dto;

import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentRsDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class RoomRsDto {
    private Integer id;
    private String name;
    private String address;
    private int costPerHour;
    private List<EquipmentRsDto> equipments;
}
