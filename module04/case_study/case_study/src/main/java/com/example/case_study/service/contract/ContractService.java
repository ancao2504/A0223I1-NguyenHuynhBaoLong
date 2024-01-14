package com.example.case_study.service.contract;

import com.example.case_study.models.Contract;
import com.example.case_study.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService extends IService<Contract> {
    Page<Contract> findAllAndPaging(Pageable pageable);
    String createCode();
}
