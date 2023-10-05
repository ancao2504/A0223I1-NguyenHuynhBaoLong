package com.example.demo.repository.impl;

import com.example.demo.database.BaseRepository;
import com.example.demo.model.Student;
import com.example.demo.repository.IRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements IRepository {
    private static final String SELECT_FROM_STUDENT = "SELECT * FROM student;";
    private static final String INSERT = "insert into student (`name`, gender, `point`)" + "values(?,?,?);";
    private static final String UPDATE_STUDENT = "UPDATE `student` SET `name`=?, gender=?, point=?  WHERE (`id` = ?);";
    private static final String SELECT_STUDENT_WHERE_ID = "SELECT * FROM student WHERE (`id` = ?);";
    public static final String DELETE_STUDENT_WHERE_ID = "delete from student where id=?;";

    @Override
    public List<Student> findAll() {
        Student student;
        List<Student> list = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_STUDENT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Boolean gender = resultSet.getBoolean("gender");
                double point = resultSet.getDouble("point");
                student = new Student(id, name, gender, point);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Student student) {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setBoolean(2, student.isGender());
            preparedStatement.setDouble(3, student.getPoint());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_WHERE_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Boolean gender = Boolean.valueOf(resultSet.getString("gender"));
                double point = Double.parseDouble(resultSet.getString("point"));
                student = new Student(id, name, gender, point);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }


    @Override
    public Boolean update(Student student) {
        boolean rowUpdate = false;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setBoolean(2, student.isGender());
            preparedStatement.setDouble(3, student.getPoint());
            preparedStatement.setInt(4,student.getId());
            rowUpdate=preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public Boolean delete(int id) {
        boolean rowDelete =false;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(DELETE_STUDENT_WHERE_ID);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
