package com.example.endmodule.service;

import com.example.endmodule.model.Category;
import com.example.endmodule.model.Color;
import com.example.endmodule.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save (Product product);
    Product findById(int id);
    void update(Product product);
    void delete(int id);

    List<Product> search(String name, Double price);
}
