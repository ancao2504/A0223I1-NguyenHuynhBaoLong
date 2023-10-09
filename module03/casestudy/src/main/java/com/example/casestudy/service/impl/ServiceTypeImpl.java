package com.example.casestudy.service.impl;

import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.TypeServiceRepository;
import com.example.casestudy.service.IServiceId;

import java.util.List;

public class ServiceTypeImpl implements IServiceId {
    private IRepositoryId iRepositoryId = new TypeServiceRepository();
    @Override
    public List findAll() {
        return iRepositoryId.findAll();
    }
}
