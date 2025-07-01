package io.github.CapUlDis.rehearsal_hub.room.repository;

import io.github.CapUlDis.rehearsal_hub.room.dto.RoomCreateDto;
import io.github.CapUlDis.rehearsal_hub.room.dto.RoomRsDto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public RoomRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RoomRsDto save(RoomCreateDto room) {
        String sql = "INSERT INTO rooms (address, name, cost_per_hour) VALUES (:address, :name, :cost_per_hour) RETURNING id, address, name, cost_per_hour";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("address", room.getAddress())
                .addValue("name", room.getName())
                .addValue("cost_per_hour", room.getCostPerHour());

        return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
                RoomRsDto.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .address(rs.getString("address"))
                        .costPerHour(rs.getInt("cost_per_hour"))
                        .build());
    }

    public void delete(String id) {
        String sql = "DELETE FROM rooms WHERE id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", Integer.parseInt(id));

        jdbcTemplate.update(sql, params);
    }
}
