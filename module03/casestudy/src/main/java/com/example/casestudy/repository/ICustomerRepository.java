package com.example.casestudy.repository;

import com.example.casestudy.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    List<Customer> findName();// dùng để hiện tên customer lên table theo id
    void save(Customer customer);
    Customer findById(int id);
    List<Customer> findByName(String name);
    Boolean update(Customer customer );
    Boolean delete(Customer customer );
}
