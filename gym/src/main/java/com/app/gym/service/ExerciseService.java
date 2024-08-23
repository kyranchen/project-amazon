package com.app.gym.service;

import com.app.gym.model.Exercise;
import com.app.gym.model.GymSet;

import java.util.List;

public interface ExerciseService {

    public List<Exercise> findAll();

    public Exercise find(Exercise exercise);

    public void insertExercise(Exercise exercise);
}
