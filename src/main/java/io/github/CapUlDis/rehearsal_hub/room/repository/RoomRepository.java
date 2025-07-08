package io.github.CapUlDis.rehearsal_hub.room.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.CapUlDis.rehearsal_hub.room.dto.RoomCreateDto;
import io.github.CapUlDis.rehearsal_hub.room.dto.RoomRsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ObjectMapper objectMapper;

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

    public RoomRsDto findById(String id) {
        String sql = """
            SELECT r.id, r.name, r.address, r.cost_per_hour,
                json_agg(json_build_object('id', e.id, 'name', e.name, 'type', e.type, 'roomId', e.room_id)) AS equipments
            FROM rooms r
            LEFT JOIN equipments e ON e.room_id = r.id
            WHERE r.id = :room_id
            GROUP BY r.id, r.name;
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("room_id", Integer.valueOf(id));

        return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) ->
        {
            try {
                return RoomRsDto.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .address(rs.getString("address"))
                    .costPerHour(rs.getInt("cost_per_hour"))
                    .equipments(objectMapper.readValue(rs.getString("equipments"), new TypeReference<>() {
                    }))
                    .build();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
