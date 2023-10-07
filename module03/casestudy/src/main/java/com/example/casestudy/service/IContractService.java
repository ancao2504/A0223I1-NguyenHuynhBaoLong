package com.example.casestudy.service;

import com.example.casestudy.model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
    void save (Contract contract);
}
