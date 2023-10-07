package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.Division;
import com.example.casestudy.model.EducationDegree;
import com.example.casestudy.repository.IRepositoryId;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IRepositoryId {

    public static final String SELECT_FROM_PART = "SELECT * FROM part;";

    @Override
    public List findAll() {
        Division division;
        List<Division> list = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_PART);
            while (resultSet.next()){
                int id = resultSet.getInt("part_id");
                String name = resultSet.getString("name");
                division = new Division(id, name);
                list.add(division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
