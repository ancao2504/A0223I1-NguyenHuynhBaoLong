package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.ServiceType;
import com.example.casestudy.repository.IRepositoryId;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeServiceRepository implements IRepositoryId {

    @Override
    public List findAll() {
        List<ServiceType> list = new ArrayList<>();
        ServiceType serviceType;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from type_service");
            while (resultSet.next()) {
                int id = resultSet.getInt("type_service_id");
                String name = resultSet.getString("name_type_service");
                serviceType= new ServiceType(id, name);
                list.add(serviceType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
