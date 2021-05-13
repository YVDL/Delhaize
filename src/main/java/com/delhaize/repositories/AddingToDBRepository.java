package com.delhaize.repositories;

import com.delhaize.domain.Category;
import com.delhaize.domain.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddingToDBRepository {


    public Category getCategoryById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Delhaize", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return Category.builder().id(resultSet.getInt("id")).categoryName(resultSet.getString("category_name")).build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addProductToDB(Product product) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Delhaize", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(product_name, description, wholesale_price, category, category_id,retail_price, quantity, store_id) values (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getWholeSale());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.setString(4, product.getCategory().getCategoryName());
            preparedStatement.setDouble(6, product.getRetailPrice());
            preparedStatement.setInt(7, product.getQuantity());
            preparedStatement.setInt(8,product.getStore().getId());
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

