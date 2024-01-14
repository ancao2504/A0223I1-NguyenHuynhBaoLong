package com.example.case_study.service.service;

import com.example.case_study.models.ServiceFurama;
import com.example.case_study.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceFurama extends IService<ServiceFurama> {
    Page<ServiceFurama> findAllByStatusTrueAndPaging(Pageable pageable);

}
