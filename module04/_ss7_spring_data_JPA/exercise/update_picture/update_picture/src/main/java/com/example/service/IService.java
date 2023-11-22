package com.example.service;

import java.util.List;

public interface IService<T> {
    void save(T t);
    T findById(int id);
    List<T> findAll();
    void deleteById(int id);
}
