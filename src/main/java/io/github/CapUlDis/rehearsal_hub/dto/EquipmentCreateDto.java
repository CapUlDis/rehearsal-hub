package io.github.CapUlDis.rehearsal_hub.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EquipmentCreateDto {
    private EquipmentType type;
    private String name;
}
