package org.example.repsitory;

import org.example.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
    List<Product> search(String name);
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
    Product detail(int id);

}
