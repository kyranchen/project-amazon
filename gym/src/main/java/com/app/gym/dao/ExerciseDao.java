package com.app.gym.dao;

import com.app.gym.model.Exercise;
import com.app.gym.model.GymSet;

import java.util.List;

public interface ExerciseDao {

    public List<Exercise> findAll();

    public Exercise find(Exercise exercise);

    public void insertExercise(Exercise exercise);
}
