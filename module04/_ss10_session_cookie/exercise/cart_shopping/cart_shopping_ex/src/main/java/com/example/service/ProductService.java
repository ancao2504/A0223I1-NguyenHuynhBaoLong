package com.example.service;

import com.example.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findByID(long id);
    Long code();
}
