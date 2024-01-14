package com.example.case_study.service.customer;

import com.example.case_study.models.Customer;
import com.example.case_study.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends IService<Customer> {
    Page<Customer> findAllByStatusTrue(Pageable pageable);

    Page<Customer> search(String name, Pageable pageable);
}
