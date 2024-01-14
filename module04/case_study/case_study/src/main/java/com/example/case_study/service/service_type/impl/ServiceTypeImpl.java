package com.example.case_study.service.service_type.impl;

import com.example.case_study.models.ServiceType;
import com.example.case_study.repository.ServiceTypeRepository;
import com.example.case_study.service.service_type.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeImpl implements IServiceType {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(int id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void delete(int id) {
        serviceTypeRepository.delete(serviceTypeRepository.findById(id).orElse(null));
    }
}
