package com.geekbrains.geekmarket.entity.category;

import com.geekbrains.geekmarket.entity.product.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.List;


@RedisHash
@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @OneToMany(mappedBy = "category")
    @OrderBy("title")
    private List<Product> products;

}
