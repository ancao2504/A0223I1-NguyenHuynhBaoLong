package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }



    @Override
    public Product findByID(int id) {
        return productRepository.findById(id).orElse(null);
    }
}
