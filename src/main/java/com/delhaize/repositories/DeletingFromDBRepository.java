package com.delhaize.repositories;

import com.delhaize.domain.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeletingFromDBRepository {

    public void deleteProductsById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Delhaize", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

            }catch(Exception e){
            e.printStackTrace();
        }
    }
}
