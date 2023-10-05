package com.example.manager_user.service;

import com.example.manager_user.model.User;

import java.util.List;

public interface IService {
    List<User> findAll();
    void save(User user);
    User findById(int id);
    Boolean update(User user);
    Boolean delete(User user);

    User findByName(String name);
}
