package com.example.case_study.service.division.impl;

import com.example.case_study.models.Division;
import com.example.case_study.repository.DivisionRepository;
import com.example.case_study.service.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findById(int id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void delete(int id) {
        divisionRepository.delete(divisionRepository.findById(id).orElse(null));
    }
}
