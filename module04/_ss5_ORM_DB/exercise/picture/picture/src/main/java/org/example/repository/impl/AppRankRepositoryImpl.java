package org.example.repository.impl;

import org.example.bean.AppRank;
import org.example.repository.IAppRankRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AppRankRepositoryImpl implements IAppRankRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<AppRank> findAll() {
        return entityManager.createQuery("from AppRank ").getResultList();
    }
}
