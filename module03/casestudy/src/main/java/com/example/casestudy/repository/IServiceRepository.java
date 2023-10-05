package com.example.casestudy.repository;

import com.example.casestudy.model.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> findAll();
    void save(Service service);
}
