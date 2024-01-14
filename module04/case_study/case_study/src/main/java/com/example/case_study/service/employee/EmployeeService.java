package com.example.case_study.service.employee;

import com.example.case_study.models.Employee;
import com.example.case_study.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService extends IService<Employee> {
    Page<Employee> findAllByStatusTrueAndPaging(Pageable pageable);

    Page<Employee> search(String name, Pageable pageable);

}
