package com.example.casestudy.service;

import com.example.casestudy.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    List<Customer> findByName(String name);
    void update(Customer customer);
    void delete(Customer customer);
}
