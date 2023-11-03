package com.example.endmodule.service.impl;

import com.example.endmodule.model.Category;
import com.example.endmodule.model.Color;
import com.example.endmodule.model.Product;
import com.example.endmodule.repository.IProductRepository;
import com.example.endmodule.repository.impl.ProductRepositoryImpl;
import com.example.endmodule.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository iProductRepository =new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
    iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Product product) {
    iProductRepository.update(product);
    }

    @Override
    public void delete(int id) {
    iProductRepository.delete(id);
    }

    @Override
    public List<Product> search(String name, Double price) {
        return iProductRepository.search(name,price);
    }
}
