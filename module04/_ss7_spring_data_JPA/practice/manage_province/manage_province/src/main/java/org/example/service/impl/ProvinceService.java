package org.example.service.impl;

import org.example.bean.Province;
import org.example.repository.IProvinceRepository;
import org.example.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;


    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public Province findById(int id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void delete(int id) {
            provinceRepository.deleteById(id);
    }
}
