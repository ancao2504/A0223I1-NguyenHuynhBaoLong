package org.example.repository;

import org.example.bean.Evaluate;

import java.util.List;

public interface IEvaluateRepository {
    List<Evaluate> findAll();
    void create(Evaluate evaluate);
    Evaluate findById(int id);
    void updateLike( Evaluate evaluate);

}
