package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.EducationDegree;
import com.example.casestudy.model.Position;
import com.example.casestudy.repository.IRepositoryId;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LevelRepository implements IRepositoryId {
    private static final String SELECT_FROM_LEVEL = "SELECT * FROM `level`;";

    @Override
    public List findAll() {
       EducationDegree educationDegree;
        List<EducationDegree> list = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_LEVEL);
            while (resultSet.next()){
                int id = resultSet.getInt("level_id");
                String name = resultSet.getString("name");
                educationDegree = new EducationDegree(id, name);
                list.add(educationDegree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
