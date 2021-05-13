package com.delhaize.services;

import com.delhaize.domain.Category;
import com.delhaize.domain.Product;
import com.delhaize.repositories.AddingToDBRepository;

public class AddingToDBService {
    private AddingToDBRepository addingToDatabaseRepository = new AddingToDBRepository();

    public Category getCategoryById(int id) {
        return addingToDatabaseRepository.getCategoryById(id);
    }

    public void addProductToDB(Product product) {
        addingToDatabaseRepository.addProductToDB(product);
    }
}

