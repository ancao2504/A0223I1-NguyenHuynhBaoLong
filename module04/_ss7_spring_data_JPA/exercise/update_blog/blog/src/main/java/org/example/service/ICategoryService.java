package org.example.service;

import org.example.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    void save(Category category);
    void delete(int id);
}
