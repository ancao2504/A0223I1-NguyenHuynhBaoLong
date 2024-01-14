package com.example.case_study.service.rent_type.impl;

import com.example.case_study.models.RentType;
import com.example.case_study.repository.RentTypeRepository;
import com.example.case_study.service.rent_type.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void delete(int id) {
        rentTypeRepository.delete(rentTypeRepository.findById(id).orElse(null));
    }
}
