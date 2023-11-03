package com.example.endmodule.repository;

import com.example.endmodule.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findById(int id);
}
