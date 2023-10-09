package com.example.casestudy.service;

import com.example.casestudy.model.ContractDetail;

import java.util.List;

public interface IDetailContractService {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
