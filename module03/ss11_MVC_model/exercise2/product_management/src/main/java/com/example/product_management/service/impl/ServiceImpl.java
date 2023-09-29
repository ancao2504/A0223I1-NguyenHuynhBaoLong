package com.example.product_management.service.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IRepository;
import com.example.product_management.repository.impl.RepositoryImpl;
import com.example.product_management.service.IService;

import java.util.List;

public class ServiceImpl implements IService {
    private static IRepository iRepository = new RepositoryImpl();

    @Override
    public List<Product> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void save(int id, Product product) {
        iRepository.save(id, product);
    }

    @Override
    public Product findById(int id) {
        return iRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iRepository.update(id,product);
    }

    @Override
    public void delete(int id) {
        iRepository.delete(id);
    }
}
