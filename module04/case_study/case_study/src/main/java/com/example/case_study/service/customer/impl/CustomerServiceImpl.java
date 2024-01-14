package com.example.case_study.service.customer.impl;

import com.example.case_study.models.Customer;
import com.example.case_study.repository.CustomerRepository;
import com.example.case_study.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(customerRepository.findById(id).orElse(null));
    }

    @Override
    public Page<Customer> findAllByStatusTrue(Pageable pageable) {
        return customerRepository.findAllByStatusTrue(pageable);
    }

    @Override
    public Page<Customer> search(String name, Pageable pageable) {
        return customerRepository.findAllByNameContainingAndStatusTrue(name, pageable);
    }
}
