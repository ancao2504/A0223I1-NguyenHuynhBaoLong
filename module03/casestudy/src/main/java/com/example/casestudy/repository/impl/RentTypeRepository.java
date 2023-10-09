package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.RentType;
import com.example.casestudy.repository.IRepositoryId;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRepositoryId {
    @Override
    public List findAll() {
        List<RentType> list = new ArrayList<>();
        RentType rentType;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from rental_type");
            while (resultSet.next()) {
                int id = resultSet.getInt("rental_type_id");
                String name = resultSet.getString("name_rental_type");
                double cost = resultSet.getDouble("cost");
                rentType = new RentType(id, name,cost);
                list.add(rentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
