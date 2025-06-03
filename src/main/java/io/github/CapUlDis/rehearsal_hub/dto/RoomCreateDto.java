package io.github.CapUlDis.rehearsal_hub.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoomCreateDto {
    private String name;
    private String address;
    private int costPerHour;
}
