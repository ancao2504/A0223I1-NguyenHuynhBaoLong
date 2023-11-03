package com.example.endmodule.repository.impl;

import com.example.endmodule.database.BaseRepository;
import com.example.endmodule.model.Category;
import com.example.endmodule.model.Color;
import com.example.endmodule.model.Product;
import com.example.endmodule.repository.ICategoryRepository;
import com.example.endmodule.repository.IColorRepo;
import com.example.endmodule.repository.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private ICategoryRepository categoryRepository = new CategoryRepositoryImpl();
    private IColorRepo colorRepo = new ColorRepoImpl();
    @Override
    public List<Product> findAll() {
        Product product;
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()) {
                Boolean status = resultSet.getBoolean("status");
                if (!status) {
                    continue;
                } else {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");
                    int idColor = resultSet.getInt("color_id");
                    Color color = colorRepo.findById(idColor);
                    String description = resultSet.getString("description");
                    int idCategory = resultSet.getInt("category_id");
                    Category category = categoryRepository.findById(idCategory);

                    product = new Product(id, name, price, quantity, color, description, category, status);
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Product product) {
        try {
            Connection connection =BaseRepository.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO `product` (`name`, `price`, `color_id`, `description`, `category_id`, `quantity`, `status`) VALUES (?,?,?,?,?,?,?);");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3, product.getColor().getId());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.setInt(6,product.getQuantity());
            preparedStatement.setBoolean(7,product.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product findById(int id) {
        Product product =null;
        try {
            Connection connection =BaseRepository.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM product WHERE id =?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                int  idColor  =resultSet.getInt("color_id");
                Color color = colorRepo.findById(idColor);
                String description  =resultSet.getString("description");
                int idCategory = resultSet.getInt("category_id");
                Category category = categoryRepository.findById(idCategory);
                Boolean status = resultSet.getBoolean("status");
                product=new Product(id,name,price,quantity,color,description,category,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Product product) {
        try {
            Connection connection =BaseRepository.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("UPDATE `product` SET `name` = ?, `price` = ?, `color_id` = ?, `description` = ?, `category_id` = ?, `quantity` = ?, `status` = ? WHERE (`id` =?);");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3, product.getColor().getId());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.setInt(6,product.getQuantity());
            preparedStatement.setBoolean(7,product.getStatus());
            preparedStatement.setInt(8,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            Connection connection =BaseRepository.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("UPDATE `product` SET `status`=0 WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> search(String name, Double price) {
        Product product;
        List<Product> list =new ArrayList<>();
        try {
            Connection connection =BaseRepository.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM product WHERE name like ? or price=? ");
            preparedStatement.setString(1,"%"+name+"%");
            preparedStatement.setDouble(2,price);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                Boolean status = resultSet.getBoolean("status");
                if (!status) {
                    continue;
                }else {
                    int id = resultSet.getInt("id");
                     name = resultSet.getString("name");
                     price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("quantity");
                    int idColor = resultSet.getInt("color_id");
                     Color color = colorRepo.findById(idColor);
                    String description = resultSet.getString("description");
                    int idCategory = resultSet.getInt("category_id");
                     Category category = categoryRepository.findById(idCategory);
                    product = new Product(id, name, price, quantity, color, description, category, status);
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
