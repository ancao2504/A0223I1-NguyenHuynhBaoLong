package com.example.case_study.repository;

import com.example.case_study.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByStatusTrue(Pageable pageable);

    Page<Employee> findAllByNameContainingAndStatusTrue(String name, Pageable pageable);
}
