package com.example.casestudy.service.impl;

import com.example.casestudy.model.ContractDetail;
import com.example.casestudy.repository.IDetailContractRepository;
import com.example.casestudy.repository.impl.DetailContractRepository;
import com.example.casestudy.service.IDetailContractService;

import java.util.List;

public class DetailContractService implements IDetailContractService {
    private IDetailContractRepository iDetailContractRepository = new DetailContractRepository();
    @Override
    public List<ContractDetail> findAll() {
        return iDetailContractRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
    iDetailContractRepository.save(contractDetail);
    }
}
