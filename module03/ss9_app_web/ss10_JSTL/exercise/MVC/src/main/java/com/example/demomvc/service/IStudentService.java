package com.example.demomvc.service;

import com.example.demomvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
    Student findById(int id);
    void update(int id, Student student);
    void remove(int id);
}
