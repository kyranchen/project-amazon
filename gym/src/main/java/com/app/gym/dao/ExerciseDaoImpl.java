package com.app.gym.dao;

import com.app.gym.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ExerciseDaoImpl implements ExerciseDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Exercise> findAll() {
        String sql = "select * from practices";
        return namedParameterJdbcTemplate.query(sql, new ExerciseMapper());
    }

    public Exercise find(Exercise exercise) {
        String sql = "select * from practices where name = :name and body_part = :group";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", exercise.getName());
        params.addValue("group", exercise.getBodyPart());
        List<Exercise> result = namedParameterJdbcTemplate.query(sql, params, new ExerciseMapper());
        if (result.size() == 0) {
            return null;
        } else {
            return result.get(0);
        }
    }

    public static final class ExerciseMapper implements RowMapper<Exercise> {
        public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
            Exercise exe = new Exercise();
            exe.setName(rs.getString("name"));
            exe.setBodyPart(rs.getString("body_part"));
            return exe;
        }
    }

    public void insertExercise(Exercise exercise) {
        Exercise result = find(exercise);
        if (result == null) {
            String insertSql = "INSERT INTO practices (name, body_part) VALUES (:name, :group)";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("name", exercise.getName());
            params.addValue("group", exercise.getBodyPart());
            namedParameterJdbcTemplate.update(insertSql, params);
        }
    }
}
