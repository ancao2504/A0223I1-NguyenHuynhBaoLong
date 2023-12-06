package com.example.service;

import java.util.List;

public interface IService<T>{
    List<T> findAll();
    void save(T t);
    void delete(int id);
    T findById(int id);

}
