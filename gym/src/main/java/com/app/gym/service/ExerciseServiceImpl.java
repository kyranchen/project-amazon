package com.app.gym.service;

import com.app.gym.dao.ExerciseDao;
import com.app.gym.model.Exercise;
import com.app.gym.model.GymSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ExerciseService")
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    private ExerciseDao exerciseDao;

    public List<Exercise> findAll() {
        return exerciseDao.findAll();
    }

    public Exercise find(Exercise exercise) {
        return exerciseDao.find(exercise);
    }

    @Override
    public void insertExercise(Exercise exercise) {
        exerciseDao.insertExercise(exercise);
    }
}
