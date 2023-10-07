package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.CustomerType;
import com.example.casestudy.repository.IRepositoryId;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepo implements IRepositoryId {

    public static final String SELECT_TYPE_SERVICE = "SELECT * FROM type_customer; ";



    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> list = new ArrayList<>();
        CustomerType customerType;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_TYPE_SERVICE);
            while (resultSet.next()) {
                int id = resultSet.getInt("type_customer_id");
                String name = resultSet.getString("name_type_customer");
                customerType = new CustomerType(id, name);
                list.add(customerType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
