package com.app.gym.dao;

import com.app.gym.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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

    public static final class ExerciseMapper implements RowMapper<Exercise> {
        public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
            Exercise exe = new Exercise();
            exe.setName(rs.getString("name"));
            exe.setBodyPart(rs.getString("body_part"));
            return exe;
        }
    }
}
