package com.delhaize.repositories;

import com.delhaize.domain.Customer;
import com.delhaize.domain.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public List<Customer> showAllCustomers() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Delhaize", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Customer> customerList = new ArrayList<>();
            while (resultSet.next()) {
                customerList.add(Customer.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("customer_name")));

            }
            return customerList;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
