package com.example.manager_user.repository.impl;

import com.example.manager_user.database.BaseRepo;
import com.example.manager_user.model.User;
import com.example.manager_user.repository.IRepository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements IRepository {

    public static final String SELECT_USER = "SELECT *from `user` ";
    public static final String INSERT_INTO_USER = "INSERT INTO `user` (`name`, `email`, `country`) VALUES (?,?,?);";
    public static final String SELECT_USER_WHERE_ID = "SELECT *from `user` where id=?;";
    public static final String UPDATE = "UPDATE `user` set `name` =?, email =?, country=? where id=?;";
    public static final String DELETE = "DELETE FROM USER WHERE ID =?;";
    public static final String SELECT_USER_WHERE_NAME_LIKE = "SELECT *from `user` where name like ?;";

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        User user;
        try {
            Connection connection = BaseRepo.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery(SELECT_USER);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name= resultSet.getString("name");
                String email= resultSet.getString("email");
                String country= resultSet.getString("country");
                user = new User(id,name, email, country);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(User user) {
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            Connection connection =BaseRepo.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_WHERE_ID);
         preparedStatement.setInt(1,id);
         ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name= resultSet.getString("name");
                String email= resultSet.getString("email");
                String country= resultSet.getString("country");
                user = new User(id,name, email, country);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Boolean update(User user) {
        Boolean rowUpdate =false;
        try {
            Connection connection =BaseRepo.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(UPDATE);
           preparedStatement.setString(1, user.getName());
           preparedStatement.setString(2, user.getEmail());
           preparedStatement.setString(3, user.getCountry());
           preparedStatement.setInt(4, user.getId());

            rowUpdate = preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            System.out.println("error update");
        }
        return rowUpdate;
    }

    @Override
    public Boolean delete(User user) {
        Boolean rowDelete= false;
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,user.getId());
            rowDelete=preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            System.out.println("error delete");
        }
        return rowDelete;
    }

    @Override
    public User findByName(String name) {
        User user=null;
        try {
            Connection connection = BaseRepo.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_WHERE_NAME_LIKE);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                 name= resultSet.getString("name");
                String email= resultSet.getString("email");
                String country= resultSet.getString("country");
                 user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
