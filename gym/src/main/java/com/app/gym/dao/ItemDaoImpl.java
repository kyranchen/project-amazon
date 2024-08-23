package com.app.gym.dao;

import com.app.gym.model.GymSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemDaoImpl implements ItemDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void insertItem(String item) {
        Map<String, Object> map = new HashMap<>();

        namedParameterJdbcTemplate.update("insert into items(id, item) value(1, 'test')", map);
    }

    @Override
    public List<GymSet> findAll() {
        String sql = "select * from user_records order by id";
        return namedParameterJdbcTemplate.query(sql, new GymSetMapper());
    }

    @Override
    public void insertSet(GymSet gymSet) {
        // Retrieve the new ID
        String getMaxIdSql = "SELECT MAX(id) + 1 FROM user_records";
        Integer newId = namedParameterJdbcTemplate.queryForObject(getMaxIdSql, new MapSqlParameterSource(), Integer.class);

        if (newId == null) {
            newId = 1;
        }
        // Insert the new row
        String insertSql = "INSERT INTO user_records (id, name, weight, reps, date) VALUES (:id, :name, :weight, :sets, :date)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", newId);
        params.addValue("name", gymSet.getName());
        params.addValue("weight", gymSet.getWeight());
        params.addValue("sets", gymSet.getSets());
        params.addValue("date", gymSet.getDate());
        namedParameterJdbcTemplate.update(insertSql, params);
    }

    public static final class GymSetMapper implements RowMapper<GymSet> {
        public GymSet mapRow(ResultSet rs, int rowNum) throws SQLException {
            GymSet gymSet = new GymSet();
            gymSet.setId(rs.getInt("id"));
            gymSet.setName(rs.getString("name"));
            gymSet.setWeight(rs.getDouble("weight"));
            gymSet.setSets(rs.getInt("reps"));
            gymSet.setDate(rs.getDate("date"));
            return gymSet;
        }
    }
}
