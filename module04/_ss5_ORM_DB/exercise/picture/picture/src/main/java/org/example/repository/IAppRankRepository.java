package org.example.repository;

import org.example.bean.AppRank;

import java.util.List;

public interface IAppRankRepository {
    List<AppRank> findAll();
}
