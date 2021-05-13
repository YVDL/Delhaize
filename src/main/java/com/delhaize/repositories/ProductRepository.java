package com.delhaize.repositories;

import com.delhaize.domain.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<Product> listOfProducts() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Delhaize", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                productList.add(Product.builder()
                        .id(resultSet.getInt("id"))
                        .productName(resultSet.getString("product_name"))
                        .description("description")
                        .build());
            }
            return productList;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> listOfDistinctShopProducts(int storeId) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Delhaize", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ? ");
            preparedStatement.setInt(1, storeId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                productList.add(Product.builder()
                        .id(resultSet.getInt("id"))
                        .productName(resultSet.getString("product_name"))
                        .description(resultSet.getString("description"))
                        .retailPrice(resultSet.getDouble("retail_price"))
                        .wholeSale(resultSet.getDouble("wholesale_price"))
                        .build());
            }
            return productList;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
