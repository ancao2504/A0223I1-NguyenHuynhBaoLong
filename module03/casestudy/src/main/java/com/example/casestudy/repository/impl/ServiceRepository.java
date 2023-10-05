package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.Service;
import com.example.casestudy.repository.IServiceRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {

    public static final String SELECT_SERVICE = "SELECT * FROM service;";
    public static final String INSERT_INTO_SERVICE = "INSERT INTO `service` (`name_service`, `area`, `rental_fee`, `max_people`, `standard_room`, `description`,`area_pool`, `floor`, `rental_type_id`, `type_service_id`) VALUES (?,?,?,?,?,?,?,?,?,?);";

    @Override
    public List<Service> findAll() {
        List<Service> list = new ArrayList<>();
        Service service;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(SELECT_SERVICE);
            while (resultSet.next()) {
                int id =resultSet.getInt("service_id");
                String name = resultSet.getString("name_service");
                int area = resultSet.getInt("area");
                double fee = resultSet.getDouble("rental_fee");
                int maxPeople= resultSet.getInt("max_people");
                String standardRoom= resultSet.getString("standard_room");
                String description = resultSet.getString("description");
                double areaPool = resultSet.getDouble("area_pool");
                int floor = resultSet.getInt("floor");
                int idRentalType = resultSet.getInt("rental_type_id");
                int idTypeService = resultSet.getInt("type_service_id");
                //int id, String name, int areaService, double costService, int maxPeople, int idRentType,
                //                   int idTypeService, String standardRoom, String description, double areaPool, int floor
                service = new Service(id, name, area, fee, maxPeople, idRentalType, idTypeService, standardRoom,
                        description, areaPool, floor);
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Service service) {
        try {
            Connection connection =BaseRepository.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(INSERT_INTO_SERVICE);
            preparedStatement.setString(1,service.getName());
            preparedStatement.setInt(2,service.getAreaService());
            preparedStatement.setDouble(3,service.getCostService());
            preparedStatement.setInt(4,service.getMaxPeople());
            preparedStatement.setString(5, service.getStandardRoom());
            preparedStatement.setString(6, service.getDescription());
            preparedStatement.setDouble(7,service.getAreaPool());
            preparedStatement.setInt(8,service.getFloor());
            preparedStatement.setInt(9,service.getIdRentType());
            preparedStatement.setInt(10,service.getIdTypeService());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
