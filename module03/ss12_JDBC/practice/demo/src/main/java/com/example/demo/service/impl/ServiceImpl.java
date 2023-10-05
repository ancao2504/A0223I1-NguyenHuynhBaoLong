package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.IRepository;
import com.example.demo.repository.impl.RepositoryImpl;
import com.example.demo.service.IService;

import java.util.List;

public class ServiceImpl implements IService {
    private IRepository iRepository = new RepositoryImpl();
    @Override
    public List<Student> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void save( Student student) {
        iRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return iRepository.findById(id);
    }

    @Override
    public Boolean update(Student student) {
        return iRepository.update(student);
    }

    @Override
    public Boolean delete(int id) {
    return iRepository.delete(id);
    }
}
