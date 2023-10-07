package com.example.casestudy.service.impl;


import com.example.casestudy.model.Position;
import com.example.casestudy.repository.IRepositoryId;
import com.example.casestudy.repository.impl.RepositoryPosition;
import com.example.casestudy.service.IServiceId;

import java.util.List;

public class PositionServiceImpl implements IServiceId {
    private IRepositoryId repositoryId = new RepositoryPosition();
    @Override
    public List<Position> findAll() {
        return repositoryId.findAll();
    }
}
