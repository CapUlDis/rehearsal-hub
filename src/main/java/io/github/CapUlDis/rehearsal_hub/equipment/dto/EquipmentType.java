package io.github.CapUlDis.rehearsal_hub.equipment.dto;

import lombok.Getter;

@Getter
public enum EquipmentType {
    ACOUSTIC_GUITAR(EquipmentCategory.GUITAR),
    ELECTRIC_GUITAR(EquipmentCategory.GUITAR),
    BASS(EquipmentCategory.GUITAR),
    DRUMS(EquipmentCategory.DRUMS),
    MIC(EquipmentCategory.MIC),
    AMPLIFIER(EquipmentCategory.AMPLIFIER),
    BASS_AMPLIFIER(EquipmentCategory.AMPLIFIER),
    CABINET(EquipmentCategory.CABINET),
    BASS_CABINET(EquipmentCategory.CABINET),
    MIXER(EquipmentCategory.MIXER),
    MONITOR(EquipmentCategory.MONITOR),
    CABLE(EquipmentCategory.CABLE);

    private final EquipmentCategory category;

    EquipmentType(EquipmentCategory category) {
        this.category = category;
    }
}
