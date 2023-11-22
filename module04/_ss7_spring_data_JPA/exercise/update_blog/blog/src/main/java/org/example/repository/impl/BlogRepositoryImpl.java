package org.example.repository.impl;

import org.example.bean.Blog;
import org.example.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        return entityManager.createQuery("from Blog " ).getResultList();
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public void save(Blog blog) {
        if (entityManager.find(Blog.class,blog.getId()) != null) {
            entityManager.merge(blog);
        }else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Blog.class,id));
    }

    @Override
    public List<Blog> fillByTitle(String name) {
        List<Blog> list = entityManager.createNamedQuery("findByTitle")
                .setParameter("title","%"+name+"%")
                .getResultList();
        return list;
    }


}
