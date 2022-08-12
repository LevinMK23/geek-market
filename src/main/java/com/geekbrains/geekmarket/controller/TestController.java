package com.geekbrains.geekmarket.controller;

import com.geekbrains.geekmarket.entity.product.Product;
import com.geekbrains.geekmarket.mapper.product.ProductMapstructMapper;
import com.geekbrains.geekmarket.model.product.Cart;
import com.geekbrains.geekmarket.model.product.ProductDto;
import com.geekbrains.geekmarket.service.CartService;
import com.geekbrains.geekmarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bad")
@Slf4j
public class TestController {

    private final ProductService productService;
    private final ProductMapstructMapper productMapstructMapper;

    private final CartService cartService;

    @GetMapping
    public List<ProductDto> getProducts() {
        List<ProductDto> list = productService.getProducts()
                .stream().map(productMapstructMapper::mapToDto)
                .toList();
        log.debug("{}", list);
        return list;
    }

    @GetMapping("/cart")
    public Cart getCart(@RequestParam Long userId) {
        return cartService.getCart(userId);
    }

}
