package com.delhaize.services;

import com.delhaize.domain.Store;
import com.delhaize.repositories.StoreRepository;

import java.util.List;

public class StoreService {
    StoreRepository storeRepository = new StoreRepository();


    public List<Store> getStores(){
        return storeRepository.getStores();
    }
}
