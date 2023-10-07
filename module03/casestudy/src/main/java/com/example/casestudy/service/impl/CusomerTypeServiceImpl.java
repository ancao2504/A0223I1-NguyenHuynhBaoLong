package com.example.casestudy.service.impl;

import com.example.casestudy.model.CustomerType;

import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.CustomerTypeRepo;
import com.example.casestudy.service.IServiceId;


import java.util.List;

public class CusomerTypeServiceImpl implements IServiceId<CustomerType> {
    private IRepositoryId<CustomerType> iFindRepo = new CustomerTypeRepo();

    @Override
    public List<CustomerType> findAll() {
        return iFindRepo.findAll();
    }

}
