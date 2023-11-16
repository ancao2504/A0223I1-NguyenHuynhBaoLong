package org.example.service;

import org.example.bean.Evaluate;

import java.util.List;

public interface IEvaluateService {
    List<Evaluate> findAll();
    void create(Evaluate evaluate);
    Evaluate findById(int id);
    void updateLike( Evaluate evaluate);
}
