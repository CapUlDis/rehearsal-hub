package io.github.CapUlDis.rehearsal_hub.equipment.repository;

import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentCreateDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentRsDto;
import io.github.CapUlDis.rehearsal_hub.equipment.dto.EquipmentType;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public EquipmentRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public EquipmentRsDto save(EquipmentCreateDto equipment) {
        String sql = "INSERT INTO equipments (type, name) VALUES (:type, :name) RETURNING id, type, name";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("type", equipment.getType().name())
                .addValue("name", equipment.getName());

        return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
                EquipmentRsDto.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .type(EquipmentType.valueOf(rs.getString("type")))
                        .category(EquipmentType.valueOf(rs.getString("type")).getCategory())
                        .build());
    }

    public void delete(String id) {
        String sql = "DELETE FROM equipments WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", Integer.parseInt(id));

        jdbcTemplate.update(sql, params);
    }

    public List<EquipmentRsDto> getAll() {
        String sql = "SELECT id, type, name FROM equipments";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
            EquipmentRsDto.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .type(EquipmentType.valueOf(rs.getString("type")))
                .category(EquipmentType.valueOf(rs.getString("type")).getCategory())
                .build());
    }
}
