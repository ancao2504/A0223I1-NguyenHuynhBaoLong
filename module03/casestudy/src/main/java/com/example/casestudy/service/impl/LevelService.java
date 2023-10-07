package com.example.casestudy.service.impl;

import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.LevelRepository;
import com.example.casestudy.service.IServiceId;

import java.util.List;

public class LevelService implements IServiceId {
    private IRepositoryId  iRepositoryId = new LevelRepository();
    @Override
    public List findAll() {
        return iRepositoryId.findAll();
    }
}
