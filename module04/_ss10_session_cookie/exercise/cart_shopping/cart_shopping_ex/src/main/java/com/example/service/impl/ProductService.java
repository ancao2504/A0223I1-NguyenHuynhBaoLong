package com.example.service.impl;

import com.example.models.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService implements com.example.service.ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByID(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Long code() {
        StringBuilder idCode= new StringBuilder();
        for (int i=1; i<=5; i++) {
            int random = (int) (Math.random()*10);
            idCode.append(random);
        }
        return Long.valueOf(String.valueOf(idCode));
    }
}
