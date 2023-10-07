package com.example.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepo {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "Long@1342004";
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Thành công");
        return connection;
    }
}
