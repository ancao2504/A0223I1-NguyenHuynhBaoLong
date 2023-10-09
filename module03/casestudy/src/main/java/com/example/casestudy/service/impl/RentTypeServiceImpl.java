package com.example.casestudy.service.impl;

import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.RentTypeRepository;
import com.example.casestudy.service.IServiceId;

import java.util.List;

public class RentTypeServiceImpl implements IServiceId {
    private IRepositoryId iRepositoryId = new RentTypeRepository();
    @Override
    public List findAll() {
        return iRepositoryId.findAll();
    }
}
