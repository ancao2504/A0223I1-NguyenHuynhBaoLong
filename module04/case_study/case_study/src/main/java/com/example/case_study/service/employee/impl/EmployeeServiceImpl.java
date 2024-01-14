package com.example.case_study.service.employee.impl;

import com.example.case_study.models.Employee;
import com.example.case_study.repository.EmployeeRepository;
import com.example.case_study.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(employeeRepository.findById(id).orElse(null));
    }

    @Override
    public Page<Employee> findAllByStatusTrueAndPaging(Pageable pageable) {
        return employeeRepository.findAllByStatusTrue(pageable);
    }

    @Override
    public Page<Employee> search(String name, Pageable pageable) {
        return employeeRepository.findAllByNameContainingAndStatusTrue(name, pageable);
    }


}
