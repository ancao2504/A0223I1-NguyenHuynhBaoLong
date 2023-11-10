package org.example.service;

import org.example.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    List<Product> search(String name);
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
}
