package org.example.repository.impl;

import org.example.bean.Evaluate;
import org.example.repository.IEvaluateRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EvaluateRepositoryImpl implements IEvaluateRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Evaluate> findAll() {
        return entityManager.createQuery("from Evaluate").getResultList();
    }

    @Override
    public void create(Evaluate evaluate) {
        entityManager.persist(evaluate);
    }

    @Override
    public Evaluate findById(int id) {
        return entityManager.find(Evaluate.class,id);
    }

    @Override
    public void updateLike(Evaluate evaluate) {
        entityManager.merge(evaluate);
    }
}
