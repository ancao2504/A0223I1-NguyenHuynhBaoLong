package org.example.repsitory.impl;

import org.example.bean.Product;
import org.example.repsitory.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<Integer, Product> map;

    static {
        map = new HashMap<>();
        map.put(1, new Product(1, "Television", 123.0, "HD", "Sam Sung"));
        map.put(2, new Product(2, "Phone", 23.0, "HD", "Sam Sung"));
        map.put(3, new Product(3, "Tablet", 12.0, "HD", "Sam Sung"));
        map.put(4, new Product(4, "Car", 123.5, "", "Tesla"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Product findById(int id) {
        return map.get(id);
    }

    @Override
    public List<Product> search(String name) {
        return null;
    }

    @Override
    public void save(Product product) {
        map.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        if (map.containsKey(id)){
            map.put(id, product);

        }
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }

    @Override
    public Product detail(int id) {
        return map.get(id);
    }
}
