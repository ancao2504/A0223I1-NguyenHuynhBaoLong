package org.example.repository.impl;

import org.example.bean.Blog;
import org.example.bean.Category;
import org.example.repository.ICategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Category> findAll() {
        return  entityManager.createQuery("from Category").getResultList();
    }

    @Override
    public Category findById(int id) {
        return entityManager.find(Category.class,id);
    }

    @Override
    public void save(Category category) {
        if (entityManager.find(Category.class,category.getId()) == null) {
            entityManager.persist(category);
        }else {
            entityManager.merge(category);
        }
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Category.class,id));
    }
}
