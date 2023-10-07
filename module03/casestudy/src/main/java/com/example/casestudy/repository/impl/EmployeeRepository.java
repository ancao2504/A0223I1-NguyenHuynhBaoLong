package com.example.casestudy.repository.impl;

import com.example.casestudy.database.BaseRepository;
import com.example.casestudy.model.Employee;
import com.example.casestudy.repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    public static final String SELECT_FROM_EMPLOYEE = "SELECT * FROM employee;";
    public static final String INSERT_INTO = "INSERT INTO `case_study`.`employee` (`name`, `day_of_birth`, `employee_code`, `salary`, `phone_number`, `email`,`address`, `position_id`, `level_id`, `part_id`, `user_name`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    public static final String SELECT_WHERE_ID = "SELECT * FROM employee where `employee_id`=?;";
    public static final String UPDATE = "UPDATE `employee` SET `name` = ?, `day_of_birth` = ?, `employee_code` = ?, `salary` = ?, `phone_number` = ?, `email`=?,`address` = ?, `position_id` = ?, `level_id` = ?, `part_id` = ? ,`user_name`= ? WHERE (`employee_id` = ?);";
    public static final String DELETE = "DELETE FROM EMPLOYEE WHERE ID =?";
    public static final String SELECT_FROM_EMPLOYEE_WHERE_NAME_LIKE = "SELECT * FROM employee where `name` like ?;";

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        Employee employee;
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_EMPLOYEE);
            while (resultSet.next()) {

                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("day_of_birth");
                String idCard = resultSet.getString("employee_code");
                double salary = resultSet.getDouble("salary");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int idPosition = resultSet.getInt("position_id");
                int idEducationDegree = resultSet.getInt("level_id");
                int idDivision = resultSet.getInt("part_id");
                String userName = resultSet.getString("user_name");
//                int id, int idCard, String name, Date birthDay, double salary, String phone, String email,
//                    String address, int idPosition, int idEducationDegree, int idDivision, String userName) {
                employee = new Employee(id, idCard, name, date, salary, phone, email, address, idPosition,
                        idEducationDegree, idDivision, userName);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Employee employee) {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, employee.getBirthDay());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getIdPosition());
            preparedStatement.setInt(9, employee.getIdEducationDegree());
            preparedStatement.setInt(10, employee.getIdDivision());
            preparedStatement.setString(11, employee.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WHERE_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id =resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("day_of_birth");
                String idCard = resultSet.getString("employee_code");
                double salary = resultSet.getDouble("salary");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int idPosition = resultSet.getInt("position_id");
                int idEducationDegree = resultSet.getInt("level_id");
                int idDivision = resultSet.getInt("part_id");
                String userName = resultSet.getString("user_name");
//                int id, int idCard, String name, Date birthDay, double salary, String phone, String email,
//                    String address, int idPosition, int idEducationDegree, int idDivision, String userName) {
                employee = new Employee(id,idCard, name, date, salary, phone, email, address, idPosition,
                        idEducationDegree, idDivision, userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        Employee employee;
        List<Employee> list = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_EMPLOYEE_WHERE_NAME_LIKE);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt("employee_id");
                 name = resultSet.getString("name");
                Date date = resultSet.getDate("day_of_birth");
                String idCard = resultSet.getString("employee_code");
                double salary = resultSet.getDouble("salary");
                String phone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int idPosition = resultSet.getInt("position_id");
                int idEducationDegree = resultSet.getInt("level_id");
                int idDivision = resultSet.getInt("part_id");
                String userName = resultSet.getString("user_name");
//                int id, int idCard, String name, Date birthDay, double salary, String phone, String email,
//                    String address, int idPosition, int idEducationDegree, int idDivision, String userName) {
                employee = new Employee(id,idCard, name, date, salary, phone, email, address, idPosition,
                        idEducationDegree, idDivision, userName);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Boolean update(Employee employee) {
        boolean rowUpdate = false;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDate(2, employee.getBirthDay());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getIdPosition());
            preparedStatement.setInt(9, employee.getIdEducationDegree());
            preparedStatement.setInt(10, employee.getIdDivision());
            preparedStatement.setString(11, employee.getUserName());
            preparedStatement.setInt(12, employee.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public Boolean delete(Employee employee) {
        boolean rowDelete = false;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, employee.getId());
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
