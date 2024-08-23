package com.app.gym.dao;

import com.app.gym.model.Exercise;

import java.util.List;

public interface ExerciseDao {

    public List<Exercise> findAll();
}
