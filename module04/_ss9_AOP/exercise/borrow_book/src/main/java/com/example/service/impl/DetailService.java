package com.example.service.impl;

import com.example.models.DetailBorrow;
import com.example.repository.IDetailRepository;
import com.example.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService implements IDetailService {

    @Autowired
    private IDetailRepository detailRepository;

    @Override
    public List<DetailBorrow> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public void save(DetailBorrow detailBorrow) {
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 10);
            codeBuilder.append(random);
        }
        detailBorrow.setCode(String.valueOf(codeBuilder));
        detailRepository.save(detailBorrow);
    }

    @Override
    public void delete(int id) {
        detailRepository.delete(detailRepository.findById(id).orElse(null));
    }

    @Override
    public DetailBorrow findById(int id) {
        return detailRepository.findById(id).orElse(null);
    }


    @Override
    public DetailBorrow findByCode(String code) {
        return detailRepository.findByCode(code);
    }

    @Override
    public void dueBorrow(String code) {
        detailRepository.delete(detailRepository.findByCode(code));
    }
}
