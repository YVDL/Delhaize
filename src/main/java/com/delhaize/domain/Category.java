package com.delhaize.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Category extends BaseEntity{
    public static Object category;
    private String categoryName;
}
