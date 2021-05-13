package com.delhaize.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Customer extends BaseEntity{

    private String customerName;

    public int getName() {
    }
}
