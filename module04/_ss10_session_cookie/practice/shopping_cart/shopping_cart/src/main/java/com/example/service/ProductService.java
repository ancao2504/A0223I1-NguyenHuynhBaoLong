package com.example.service;


import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findByID(int id);
}
