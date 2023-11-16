package org.example.service.impl;

import org.example.bean.Product;
import org.example.repsitory.IProductRepository;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> search(String name) {
        return null;
    }

    @Override
    public void save(Product product) {
    productRepository.save(product);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void delete(int id) {
    productRepository.delete(id);
    }

    @Override
    public Product detail(int id) {
        return productRepository.detail(id);
    }
}
