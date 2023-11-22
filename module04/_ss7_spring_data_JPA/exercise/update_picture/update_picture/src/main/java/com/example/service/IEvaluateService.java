package com.example.service;

import com.example.bean.Evaluate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IEvaluateService extends IService<Evaluate> {
    Page<Evaluate> findAllAndPaging(Pageable pageable);

}
