package com.example.case_study.service.contract_detail.impl;

import com.example.case_study.models.ContractDetail;
import com.example.case_study.repository.ContractDetailRepository;
import com.example.case_study.service.contract_detail.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void delete(int id) {
        contractDetailRepository.delete(contractDetailRepository.findById(id).orElse(null));
    }

    @Override
    public List<ContractDetail> findByContract_Id(int idContract) {
        return contractDetailRepository.findByContract_Id(idContract);
    }
}
