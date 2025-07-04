package io.github.CapUlDis.rehearsal_hub.equipment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EquipmentCreateDto {
    private EquipmentType type;
    private String name;
    private Integer roomId;
}
