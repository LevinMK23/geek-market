package com.geekbrains.geekmarket.controller;

import com.geekbrains.geekmarket.mapper.product.ProductMapper;
import com.geekbrains.geekmarket.model.product.ProductDto;
import com.geekbrains.geekmarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts().stream()
                .map(productMapper::mapToDto)
                .toList();
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto product) {
        return productMapper.mapToDto(productService.create(product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
