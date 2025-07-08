package io.github.CapUlDis.rehearsal_hub.equipment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("category")
    public EquipmentCategory getCategory() {
        return type != null ? type.getCategory() : null;
    }
}
