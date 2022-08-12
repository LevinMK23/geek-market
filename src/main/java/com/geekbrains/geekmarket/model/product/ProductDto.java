package com.geekbrains.geekmarket.model.product;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String title;
    private String categoryTitle;
    private Double price;

}
