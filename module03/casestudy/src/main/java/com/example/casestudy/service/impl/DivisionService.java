package com.example.casestudy.service.impl;

import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.DivisionRepository;
import com.example.casestudy.service.IServiceId;

import java.util.List;

public class DivisionService implements IServiceId {
    private IRepositoryId iRepositoryId =new DivisionRepository();
    @Override
    public List findAll() {
        return iRepositoryId.findAll();
    }
}
