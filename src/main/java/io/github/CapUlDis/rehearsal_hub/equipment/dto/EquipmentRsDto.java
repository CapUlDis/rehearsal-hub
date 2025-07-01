package io.github.CapUlDis.rehearsal_hub.equipment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EquipmentRsDto {
    private Integer id;
    private EquipmentType type;
    private EquipmentCategory category;
    private String name;
    private Integer roomId;
}
