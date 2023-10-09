package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.DetailCustomer;
import com.example.casestudy.repository.IDetailCustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailCustomerRepository implements IDetailCustomerRepository {
    @Override
    public List<DetailCustomer> list() {
        List<DetailCustomer> list = new ArrayList();
        DetailCustomer detailCustomer;
        try {
            Connection connection = BaseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall("call customer_are_using();");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("name_customer");
                Date birthDay = resultSet.getDate("day_of_birth");
                Boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("customer_code");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                int idTypeCustomer = resultSet.getInt("type_customer_id");
//int id, int idCustomerType, String name, Date birthDay, boolean gender, String idCard,
//                          String phone, String email, String address, int idServiceID, int idTypeService, int idAttachService
                int idService = resultSet.getInt("service_id");
                int idTypeService = resultSet.getInt("type_service_id");
                int idAttachService = resultSet.getInt("accompanied_service_id");
                detailCustomer = new DetailCustomer(id,idTypeCustomer ,name, birthDay, gender, idCard, email, phone, address,
                        idService, idTypeService, idAttachService);
                list.add(detailCustomer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
