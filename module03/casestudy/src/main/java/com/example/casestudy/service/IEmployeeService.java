package com.example.casestudy.service;

import com.example.casestudy.model.Employee;
import com.example.casestudy.model.User;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    Employee findById(int id);
    List<Employee> findByName(String name);
    Boolean update(Employee employee );
    Boolean delete(Employee employee );
    Boolean checkUser(User user);
}
