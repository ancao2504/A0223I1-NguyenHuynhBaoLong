package com.example.manager_user.service.impl;

import com.example.manager_user.model.User;
import com.example.manager_user.repository.IRepository;
import com.example.manager_user.repository.impl.RepositoryImpl;
import com.example.manager_user.service.IService;

import java.util.List;

public class ServiceImpl implements IService {
    private IRepository iRepository = new RepositoryImpl();
    @Override
    public List<User> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void save(User user) {
    iRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return iRepository.findById(id);
    }

    @Override
    public Boolean update(User user) {
        return iRepository.update(user);
    }

    @Override
    public Boolean delete(User user) {
        return iRepository.delete(user);
    }

    @Override
    public User findByName(String name) {
        return iRepository.findByName(name);
    }
}
