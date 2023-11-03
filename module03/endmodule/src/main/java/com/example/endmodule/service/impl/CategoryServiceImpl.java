package com.example.endmodule.service.impl;

import com.example.endmodule.model.Category;
import com.example.endmodule.repository.ICategoryRepository;
import com.example.endmodule.repository.impl.CategoryRepositoryImpl;
import com.example.endmodule.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private ICategoryRepository iCategoryRepository = new CategoryRepositoryImpl();
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return iCategoryRepository.findById(id);
    }
}
