package org.example.service.impl;

import org.example.bean.AppRank;
import org.example.repository.IAppRankRepository;
import org.example.service.IAppRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRankServiceImpl implements IAppRankService {
    @Autowired
    private IAppRankRepository iAppRankRepository;
    @Override
    public List<AppRank> findAll() {
        return iAppRankRepository.findAll();
    }
}
