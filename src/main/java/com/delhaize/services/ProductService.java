package com.delhaize.services;

import com.delhaize.domain.Product;
import com.delhaize.repositories.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();
    public List<Product> listOfProducts() {
        return productRepository.listOfProducts();
    }


    public List<Product> listOfDistinctShopProducts(int storeId) {

        return productRepository.listOfDistinctShopProducts(storeId);
    }
}

