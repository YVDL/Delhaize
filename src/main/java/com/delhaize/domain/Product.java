package com.delhaize.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class Product extends BaseEntity {
    private String productName;
    private Category category;
    private String description;
    private double wholeSale;
    private double retailPrice;
    private int quantity;
    private Store store;
}
