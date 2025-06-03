package io.github.CapUlDis.rehearsal_hub.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class EquipmentRsDto {
    private UUID id;
    private EquipmentType type;
    private String name;
}
