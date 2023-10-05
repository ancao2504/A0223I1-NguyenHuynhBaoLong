package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.IRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryImpl implements IRepository {
    private static Map<Integer, Product> products;
    private static ArrayList<Product> list = new ArrayList();
    static {
        products = new HashMap<>();
        products.put(1, new Product("banh", 1, 123.3, "12/12/1223"));
        products.put(2, new Product("banh", 2, 123.3, "12/12/1223"));
        products.put(3, new Product("banh", 3, 123.3, "12/12/1223"));
        products.put(4, new Product("banh", 4, 123.3, "12/12/1223"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());

    }

    @Override
    public void save(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
