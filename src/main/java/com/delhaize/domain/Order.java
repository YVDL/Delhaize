package com.delhaize.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class Order extends BaseEntity{
    private String orderName;
    private List<Product> orderList;
    private Customer customer;

}
