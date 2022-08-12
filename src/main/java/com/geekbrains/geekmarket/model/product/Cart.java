package com.geekbrains.geekmarket.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {

    private Long userId;
    private List<CartItem> items;
}
