package com.example.casestudy.service.impl;

import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.AttachServiceRepository;
import com.example.casestudy.service.IServiceId;

import java.util.List;

public class AttachServiceImpl implements IServiceId {
    private IRepositoryId<AttachServiceImpl> iRepositoryId = new AttachServiceRepository();
    @Override
    public List findAll() {
        return iRepositoryId.findAll();
    }
}
