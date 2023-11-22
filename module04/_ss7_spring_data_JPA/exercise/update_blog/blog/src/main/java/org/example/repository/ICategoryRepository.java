package org.example.repository;

import org.example.bean.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findById(int id);
    void save(Category category);
    void delete(int id);
}
