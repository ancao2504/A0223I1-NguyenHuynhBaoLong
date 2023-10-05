package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;

public interface IRepository {
    List<Student> findAll();
    void save(Student student);
    Student findById(int id);
    Boolean update( Student student);
    Boolean delete(int id);
}
