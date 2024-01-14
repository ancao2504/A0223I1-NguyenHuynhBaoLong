package com.example.case_study.service.position.impl;

import com.example.case_study.models.Position;
import com.example.case_study.repository.PositionRepository;
import com.example.case_study.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findById(int id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void delete(int id) {
        positionRepository.delete(positionRepository.findById(id).orElse(null));
    }
}
