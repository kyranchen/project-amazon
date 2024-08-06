package com.app.gym.service;

import com.app.gym.model.GymSet;

import java.util.List;

public interface ItemService {
    public void insertItem(String item);

    public List<GymSet> findAll();

    public void insertSet(GymSet gymSet);
}
