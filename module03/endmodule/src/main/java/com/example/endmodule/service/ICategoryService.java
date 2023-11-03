package com.example.endmodule.service;

import com.example.endmodule.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
}
