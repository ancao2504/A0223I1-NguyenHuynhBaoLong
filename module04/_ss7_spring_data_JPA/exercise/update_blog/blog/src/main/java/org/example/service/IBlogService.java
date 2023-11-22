package org.example.service;

import org.example.bean.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
    @Query("from Blog b where b.title like :title")
    List<Blog> fillByTitle(@Param("title") String name);
}
