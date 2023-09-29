package com.example.customer.Service.impl;

import com.example.customer.Model.Customer;
import com.example.customer.Service.IService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements IService {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1,new Customer(1,"Dat","dat@123","Đà Nẵng"));
        customers.put(2,new Customer(2,"LL","dat@123","Đà Nẵng"));
        customers.put(3,new Customer(3,"T","dat@123","HN"));
        customers.put(4,new Customer(4,"H","dat@123","Đà Nẵng"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void delete(int id) {
        customers.remove(id);
    }


}
