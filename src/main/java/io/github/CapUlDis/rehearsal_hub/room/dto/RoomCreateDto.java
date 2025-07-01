package io.github.CapUlDis.rehearsal_hub.room.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RoomCreateDto {
    private String name;
    private String address;
    private Integer roomId;
    private List<Integer> equipmentIds;
    private int costPerHour;
}
