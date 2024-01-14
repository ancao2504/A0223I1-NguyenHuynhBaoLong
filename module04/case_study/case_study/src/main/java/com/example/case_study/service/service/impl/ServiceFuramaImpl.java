package com.example.case_study.service.service.impl;

import com.example.case_study.models.ServiceFurama;
import com.example.case_study.repository.ServiceFuramaRepository;
import com.example.case_study.service.service.IServiceFurama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFuramaImpl implements IServiceFurama {
    @Autowired
    private ServiceFuramaRepository serviceFuramaRepository;

    @Override
    public List<ServiceFurama> findAll() {
        return serviceFuramaRepository.findAll();
    }

    @Override
    public ServiceFurama findById(int id) {
        return serviceFuramaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceFurama serviceFurama) {
        serviceFuramaRepository.save(serviceFurama);
    }

    @Override
    public void delete(int id) {
        serviceFuramaRepository.delete(serviceFuramaRepository.findById(id).orElse(null));
    }

    @Override
    public Page<ServiceFurama> findAllByStatusTrueAndPaging(Pageable pageable) {
        return serviceFuramaRepository.findAllByStatusTrue(pageable);
    }
}
