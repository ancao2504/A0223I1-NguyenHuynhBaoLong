package com.example.service.impl;

import com.example.bean.Evaluate;
import com.example.repository.IEvaluateRepository;
import com.example.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements IEvaluateService {
    @Autowired
    private IEvaluateRepository evaluateRepository;

    @Override
    public void save(Evaluate evaluate) {
        evaluateRepository.save(evaluate);
    }

    @Override
    public Evaluate findById(int id) {
        return evaluateRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evaluate> findAll() {
        return evaluateRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        evaluateRepository.deleteById(id);
    }

    @Override
    public Page<Evaluate> findAllAndPaging(Pageable pageable) {
        return evaluateRepository.findAll(pageable);
    }
}
