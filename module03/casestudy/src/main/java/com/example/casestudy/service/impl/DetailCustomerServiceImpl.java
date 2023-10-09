package com.example.casestudy.service.impl;

import com.example.casestudy.model.DetailCustomer;
import com.example.casestudy.repository.IDetailCustomerRepository;
import com.example.casestudy.repository.impl.DetailCustomerRepository;
import com.example.casestudy.service.IDetailCustomerService;

import java.util.List;

public class DetailCustomerServiceImpl implements IDetailCustomerService {
    private IDetailCustomerRepository iDetailCustomerRepository = new DetailCustomerRepository();
    @Override
    public List<DetailCustomer> list() {
        return iDetailCustomerRepository.list();
    }
}
