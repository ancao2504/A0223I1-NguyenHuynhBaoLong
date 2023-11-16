package org.example.repository.impl;

import org.example.bean.Music;
import org.example.repository.IMusicRepository;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepositoryImpl implements IMusicRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        String queryStr = "from Music ";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }
}
