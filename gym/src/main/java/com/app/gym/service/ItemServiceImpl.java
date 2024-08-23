package com.app.gym.service;

import com.app.gym.dao.ItemDao;
import com.app.gym.model.Exercise;
import com.app.gym.model.GymSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Autowired
    ExerciseService exerciseService;

    @Override
    public void insertItem(String item) {
        itemDao.insertItem(item);
    }

    @Override
    public List<GymSet> findAll() {
        return itemDao.findAll();
    }

    @Override
    @Transactional
    public void insertSet(GymSet gymSet) {
        itemDao.insertSet(gymSet);

        Exercise exercise = new Exercise();
        exercise.setName(gymSet.getName());
        exercise.setBodyPart(gymSet.getGroup());
        exerciseService.insertExercise(exercise);
    }
}
