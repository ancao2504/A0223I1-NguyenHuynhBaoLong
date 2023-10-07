package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.IRepository;
import com.example.demo.repository.impl.RepositoryImpl;
import com.example.demo.service.IService;

import java.util.List;

public class Service implements IService {
    private IRepository iRepository = new RepositoryImpl();
    @Override
    public List<Student> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void save(int id, Student student) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Student student) {

    }

    @Override
    public void delete(int id) {

    }
}
