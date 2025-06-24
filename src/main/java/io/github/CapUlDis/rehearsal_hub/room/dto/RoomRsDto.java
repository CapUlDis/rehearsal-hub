package io.github.CapUlDis.rehearsal_hub.room.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class RoomRsDto {
    private Integer id;
    private String name;
    private String address;
    private int costPerHour;
}
