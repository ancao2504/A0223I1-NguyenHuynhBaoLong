package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface IService {
    List<Student> findAll();
    void save(Student student);
    Student findById(int id);
    Boolean update(Student student);
    Boolean delete(int id);
}
