package org.example.repository;

import org.example.bean.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
}
