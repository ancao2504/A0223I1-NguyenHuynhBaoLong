package org.example.repository;

import org.example.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
    @Query("from Blog b where b.title like :title")
    List<Blog> fillByTitle(@Param("title") String name);
}
