package com.delhaize.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class Store extends BaseEntity{

    private String storeName;
    private List<Product> productList;

}
