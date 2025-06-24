package io.github.CapUlDis.rehearsal_hub.equipment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class EquipmentsRsDto {
    private List<EquipmentRsDto> items;
}
