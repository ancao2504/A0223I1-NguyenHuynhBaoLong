package com.example.customer.Service;

import com.example.customer.Model.Customer;

import java.util.List;

public interface IService {
    List<Customer> findAll();
    void save(int id, Customer customer);
    Customer findById(int id);
    void update(int id, Customer customer);

    void delete(int id);
}
