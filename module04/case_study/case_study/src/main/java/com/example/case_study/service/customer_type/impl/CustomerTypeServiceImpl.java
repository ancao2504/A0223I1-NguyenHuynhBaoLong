package com.example.case_study.service.customer_type.impl;

import com.example.case_study.models.CustomerType;
import com.example.case_study.repository.CustomerTypeRepository;
import com.example.case_study.service.customer_type.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void delete(int id) {
        customerTypeRepository.delete(customerTypeRepository.findById(id).orElse(null));
    }
}
