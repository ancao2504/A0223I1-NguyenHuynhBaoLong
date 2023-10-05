package com.example.casestudy.repository;



import com.example.casestudy.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();
    void save(Employee employee);
    Employee findById(int id);
    List<Employee> findByName(String name);
    Boolean update(Employee employee );
    Boolean delete(Employee employee );
}
