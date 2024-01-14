package com.example.case_study.service.contract_detail;

import com.example.case_study.models.ContractDetail;
import com.example.case_study.service.IService;

import java.util.List;

public interface ContractDetailService extends IService<ContractDetail> {
    List<ContractDetail> findByContract_Id(int idContract);

}
