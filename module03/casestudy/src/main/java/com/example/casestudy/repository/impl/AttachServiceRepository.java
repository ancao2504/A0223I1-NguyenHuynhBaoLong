package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.AttachService;
import com.example.casestudy.repository.IRepositoryId;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository implements IRepositoryId {

    public static final String SELECT_FROM_ACCOMPANIED_SERVICE = "select * from accompanied_service";

    @Override
    public List findAll() {
        List<AttachService> list = new ArrayList<>();
        AttachService attachService;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_ACCOMPANIED_SERVICE);
            while (resultSet.next()) {
//                accompanied_service_id int AI PK
//name_accompanied_service varchar(45)
//price double
//measure varchar(45)
//status varchar(45)
                int id = resultSet.getInt("accompanied_service_id");
                String name = resultSet.getString("name_accompanied_service");
                double price = resultSet.getDouble("price");
                int measure = resultSet.getInt("measure");
                String status = resultSet.getString("status");
//                int id, String name, double costAttachService, int unitAttachService, String status
                attachService= new AttachService(id, name, price, measure, status);
                list.add(attachService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
