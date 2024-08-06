package com.app.gym.service;

import com.app.gym.dao.ItemDao;
import com.app.gym.model.GymSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Override
    public void insertItem(String item) {
        itemDao.insertItem(item);
    }

    @Override
    public List<GymSet> findAll() {
        return itemDao.findAll();
    }

    @Override
    public void insertSet(GymSet gymSet) {
        itemDao.insertSet(gymSet);
    }
}
