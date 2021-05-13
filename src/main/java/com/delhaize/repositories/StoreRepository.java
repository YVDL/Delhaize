package com.delhaize.repositories;

import com.delhaize.domain.Store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreRepository {

    public List<Store> getStores() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Delhaize", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from store");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Store> storeList = new ArrayList<>();
            while (resultSet.next()) {
                storeList.add(Store.builder()
                        .id(resultSet.getInt("id"))
                        .storeName(resultSet
                                .getString("store_name")).id(resultSet.getInt("id")).build());
            }
            return storeList;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

