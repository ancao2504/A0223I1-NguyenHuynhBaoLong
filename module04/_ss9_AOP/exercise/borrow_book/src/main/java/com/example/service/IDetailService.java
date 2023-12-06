package com.example.service;

import com.example.models.DetailBorrow;

public interface IDetailService extends IService<DetailBorrow> {
    DetailBorrow findByCode(String code);
    void dueBorrow(String code);


}
