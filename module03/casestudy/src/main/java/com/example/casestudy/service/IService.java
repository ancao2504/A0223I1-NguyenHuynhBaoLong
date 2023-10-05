package com.example.casestudy.service;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Service;

import java.util.List;

public interface IService {
    List<Service> findAll();
    void save(Service service);
}
