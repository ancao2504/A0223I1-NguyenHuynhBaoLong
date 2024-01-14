package com.example.case_study.repository;

import com.example.case_study.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByStatusTrue(Pageable pageable);

    Page<Customer> findAllByNameContainingAndStatusTrue(String name, Pageable pageable);
}
