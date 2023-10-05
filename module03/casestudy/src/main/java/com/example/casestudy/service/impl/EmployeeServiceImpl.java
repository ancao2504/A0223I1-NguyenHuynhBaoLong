package com.example.casestudy.service.impl;

import com.example.casestudy.model.Employee;
import com.example.casestudy.repository.IEmployeeRepository;
import com.example.casestudy.repository.impl.EmployeeRepository;
import com.example.casestudy.service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }

    @Override
    public Boolean update(Employee employee) {
        return iEmployeeRepository.update(employee);
    }

    @Override
    public Boolean delete(Employee employee) {
        return iEmployeeRepository.delete(employee);
    }
}
