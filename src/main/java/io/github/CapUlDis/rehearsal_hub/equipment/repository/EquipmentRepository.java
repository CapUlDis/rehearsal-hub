package io.github.CapUlDis.rehearsal_hub.equipment.repository;

import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentCreateDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentRsDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class EquipmentRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public EquipmentRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public EquipmentRsDto save(EquipmentCreateDto equipment) {
        String sql = "INSERT INTO equipments (type, name, room_id) VALUES (:type, :name, :room_id) RETURNING id, type, name, room_id";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("type", equipment.getType().name())
                .addValue("name", equipment.getName())
                .addValue("room_id", equipment.getRoomId());

        return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
                EquipmentRsDto.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .type(EquipmentType.valueOf(rs.getString("type")))
                        .category(EquipmentType.valueOf(rs.getString("type")).getCategory())
                        .roomId(rs.getInt("room_id"))
                        .build());
    }

    public void delete(String id) {
        String sql = "DELETE FROM equipments WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", Integer.parseInt(id));

        jdbcTemplate.update(sql, params);
    }

    public List<EquipmentRsDto> getAll() {
        String sql = "SELECT id, type, name, room_id FROM equipments";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            EquipmentRsDto.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .type(EquipmentType.valueOf(rs.getString("type")))
                .roomId(rs.getInt("room_id"))
                .build());
    }

    public List<EquipmentRsDto> assignToRoom(List<Integer> equipmentIds, Integer roomId) {
        String sql = "UPDATE equipments SET room_id = :room_id WHERE id IN (:ids) RETURNING id, type, name, room_id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("room_id", roomId);
        params.addValue("ids", equipmentIds);

        return jdbcTemplate.query(sql, params, (rs, rowNum) ->
                EquipmentRsDto.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .type(EquipmentType.valueOf(rs.getString("type")))
                        .category(EquipmentType.valueOf(rs.getString("type")).getCategory())
                        .roomId(rs.getInt("room_id"))
                        .build());
    }
}
