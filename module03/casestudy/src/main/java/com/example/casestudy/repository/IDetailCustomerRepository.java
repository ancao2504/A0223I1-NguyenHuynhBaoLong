package com.example.casestudy.repository;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.DetailCustomer;

import java.util.List;

public interface IDetailCustomerRepository {
    List<DetailCustomer> list();
}
