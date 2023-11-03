package com.example.endmodule.repository.impl;

import com.example.endmodule.database.BaseRepository;
import com.example.endmodule.model.Category;
import com.example.endmodule.model.Color;
import com.example.endmodule.repository.IColorRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColorRepoImpl implements IColorRepo {
    @Override
    public List<Color> findAll() {
        Color color;
        List<Color> list =new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =statement.executeQuery("SELECT * FROM color");
            while (resultSet.next()) {
                int id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                color = new Color(id, name);
                list.add(color);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Color findById(int id) {
        Color color = null;
        try {
            Connection connection = BaseRepository.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM color where id=?");
           preparedStatement.setInt(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                 id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                color = new Color(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return color;
    }
}
