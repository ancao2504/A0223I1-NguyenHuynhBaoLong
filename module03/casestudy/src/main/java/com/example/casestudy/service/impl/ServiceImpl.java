package com.example.casestudy.service.impl;


import com.example.casestudy.model.Service;
import com.example.casestudy.repository.IServiceRepository;
import com.example.casestudy.repository.impl.ServiceRepository;
import com.example.casestudy.service.IService;

import java.util.List;

public class ServiceImpl implements IService {
    private IServiceRepository iServiceRepository =new ServiceRepository();

    @Override
    public List<Service> findAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public void save(Service service) {
    iServiceRepository.save(service);
    }


}
