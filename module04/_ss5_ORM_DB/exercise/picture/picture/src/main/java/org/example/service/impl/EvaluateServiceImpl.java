package org.example.service.impl;

import org.example.bean.Evaluate;
import org.example.repository.IEvaluateRepository;
import org.example.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements IEvaluateService {
    @Autowired
    private IEvaluateRepository evaluateRepository;
    @Override
    public List<Evaluate> findAll() {
        return evaluateRepository.findAll();
    }

    @Override
    public void create(Evaluate evaluate) {
        evaluateRepository.create(evaluate);
    }

    @Override
    public Evaluate findById(int id) {
        return evaluateRepository.findById(id);
    }

    @Override
    public void updateLike(Evaluate evaluate) {
        evaluateRepository.updateLike(evaluate);
    }
}
