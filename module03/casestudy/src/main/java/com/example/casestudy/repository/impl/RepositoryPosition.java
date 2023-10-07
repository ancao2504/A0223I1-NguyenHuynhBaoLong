package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.CustomerType;
import com.example.casestudy.model.Position;
import com.example.casestudy.repository.IRepositoryId;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositoryPosition implements IRepositoryId {

    public static final String SELECT_FROM_POSITION = "SELECT * FROM position;";

    @Override
    public List<Position> findAll() {
        Position position;
        List<Position> list = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_POSITION);
            while (resultSet.next()){
                int id = resultSet.getInt("position_id");
                String name = resultSet.getString("name");
                position = new Position(id, name);
                list.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
