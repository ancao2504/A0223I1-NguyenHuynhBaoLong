package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.Customer;
import com.example.casestudy.model.Division;
import com.example.casestudy.repository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public class CustomerRepositoryImpl implements ICustomerRepository {

    public static final String SELECT_CUSTOMER = " SELECT * FROM customer;";
    public static final String INSERT_CUSTOMER = "INSERT INTO `customer` (`name_customer`, `day_of_birth`, `gender`, `customer_code`, `phone_number`, `email`, `address`, `type_customer_id`,`status`) VALUES (?,?,?,?,?,?,?,?,?);";
    public static final String SELECT_CUSTOMER_WHERE_ID = "SELECT * FROM customer where customer_id=?";
    public static final String UPDATE = "UPDATE `customer` SET `name_customer` = ? ,`day_of_birth` = ?, `gender` = ?, `customer_code` = ?, `phone_number` = ?, `email` =?, `address` = ?, `type_customer_id` = ? WHERE (`customer_id` = ?);";
    public static final String DELETE = "UPDATE `customer` SET `status` = '0' WHERE (`customer_id` = ?);";
    public static final String SELECT_CUSTOMER_WHERE_NAME = "SELECT * FROM customer where `name_customer` like ?;";


    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        Customer customer =null;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CUSTOMER);
            while (resultSet.next()) {
                boolean status = resultSet.getBoolean("status");
                if (!status) {
                    continue;
                }else {
                    int id = resultSet.getInt("customer_id");
                    String name = resultSet.getString("name_customer");
                    Date birthDay = resultSet.getDate("day_of_birth");
                    Boolean gender = resultSet.getBoolean("gender");
                    String idCard = resultSet.getString("customer_code");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone_number");
                    String address = resultSet.getString("address");
                    int idTypeCustomer = resultSet.getInt("type_customer_id");

                    customer = new Customer(id, idTypeCustomer, name, birthDay, gender, idCard, phone, email, address);
                    list.add(customer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Customer> findName() {
        Customer customer;
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer where ;");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

        @Override
//    public void save(Customer customer) {
//        try {
//            Connection connection = BaseRepository.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
//            //(`name_customer`, `day_of_birth`, `gender`, `customer_code`, `phone_number`, `email`, `address`, `type_customer_id`)
//            preparedStatement.setString(1, customer.getName());
////            preparedStatement.setDate(2, customer.getBirthDay());
//            Date sqlDate = new Date(customer.getBirthDay().getTime());
//            preparedStatement.setDate(2,sqlDate);
//            preparedStatement.setBoolean(3, customer.isGender());
//            preparedStatement.setString(4, customer.getIdCard());
//            preparedStatement.setString(5, customer.getPhone());
//            preparedStatement.setString(6, customer.getEmail());
//            preparedStatement.setString(7, customer.getAddress());
//            preparedStatement.setInt(8, customer.getIdCustomerType());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
 //   }
        public void save(Customer customer) {
        Boolean status =true ;
            try {
                Connection connection = BaseRepository.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
                //(`name_customer`, `day_of_birth`, `gender`, `customer_code`, `phone_number`, `email`, `address`, `type_customer_id`)
                preparedStatement.setString(1, customer.getName());
//            preparedStatement.setDate(2, customer.getBirthDay());
                Date sqlDate = new Date(customer.getBirthDay().getTime());
                preparedStatement.setDate(2, sqlDate);
                preparedStatement.setBoolean(3, customer.isGender());
                preparedStatement.setString(4, customer.getIdCard());
                preparedStatement.setString(5, customer.getPhone());
                preparedStatement.setString(6, customer.getEmail());
                preparedStatement.setString(7, customer.getAddress());
                preparedStatement.setInt(8, customer.getIdCustomerType());
                preparedStatement.setBoolean(9, customer.getStatus());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public Customer findById(int id) {
        System.out.println("id " + id);
        Customer customer = null;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_WHERE_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("customer_id");
                String name = resultSet.getString("name_customer");
                Date birthDay = resultSet.getDate("day_of_birth");
                Boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("customer_code");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                int idTypeCustomer = resultSet.getInt("type_customer_id");
                customer = new Customer(id, idTypeCustomer, name, birthDay, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> list = new ArrayList<>();
        Customer customer;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_WHERE_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                name = resultSet.getString("name_customer");
                Date birthDay = resultSet.getDate("day_of_birth");
                Boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("customer_code");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                int idTypeCustomer = resultSet.getInt("type_customer_id");
                customer = new Customer(id, idTypeCustomer, name, birthDay, gender, idCard, phone, email, address);
                list.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
        @Override
    public Boolean update(Customer customer) {
        Boolean rowUpdate = false;
        try {
//`name_customer` = ? `day_of_birth` = ?, `gender` = ?, `customer_code` = ?, `phone_number` = ?, `email` =?,
// `address` = ?, `type_customer_id` = ? WHERE (`customer_id` = ?);
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, customer.getName());
            Date date = new Date(customer.getBirthDay().getTime());
            preparedStatement.setDate(2, date);
            preparedStatement.setBoolean(3, customer.isGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getIdCustomerType());
            preparedStatement.setInt(9, customer.getId());
            rowUpdate = preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(rowUpdate);
        return rowUpdate;
    }

    @Override
    public Boolean delete(Customer customer) {
        Boolean rowDelete = false;
        try {
            Connection connection = BaseRepository.getConnection();
            CallableStatement CallableStatement = connection.prepareCall(DELETE);
            CallableStatement.setInt(1, customer.getId());
            rowDelete = CallableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
