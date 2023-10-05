package com.example.casestudy.repository;

import com.example.casestudy.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    List<Customer> findByName(String name);
    Boolean update(Customer customer );
    Boolean delete(Customer customer );
}
