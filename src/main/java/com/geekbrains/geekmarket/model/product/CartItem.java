package com.geekbrains.geekmarket.model.product;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CartItem implements Serializable {

    private Long id;
    private String title;
    private Long count;
    private Double price;
    private Double sum;

}
