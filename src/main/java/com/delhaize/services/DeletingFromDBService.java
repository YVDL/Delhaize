package com.delhaize.services;

import com.delhaize.repositories.DeletingFromDBRepository;

public class DeletingFromDBService {
    DeletingFromDBRepository deletingFromDBRepository = new DeletingFromDBRepository();

    public void deleteProductById(int id) {
        deletingFromDBRepository.deleteProductsById(id);
    }

}
