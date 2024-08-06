package com.app.gym.dao;

import com.app.gym.model.GymSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {
    public void insertItem(String item);

    public List<GymSet> findAll();

    public void insertSet(GymSet gymSet);
}
