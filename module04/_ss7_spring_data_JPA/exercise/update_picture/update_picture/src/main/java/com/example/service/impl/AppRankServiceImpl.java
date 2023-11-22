package com.example.service.impl;

import com.example.bean.AppRank;
import com.example.repository.IAppRankRepository;
import com.example.service.IAppRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRankServiceImpl implements IAppRankService {
    @Autowired
    private IAppRankRepository iAppRankRepository;

    @Override
    public void save(AppRank appRank) {
        iAppRankRepository.save(appRank);
    }

    @Override
    public AppRank findById(int id) {
        return iAppRankRepository.findById(id).orElse(null);
    }

    @Override
    public List<AppRank> findAll() {
        return iAppRankRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        iAppRankRepository.deleteById(id);
    }
}
