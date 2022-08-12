package com.geekbrains.geekmarket.service;

import com.geekbrains.geekmarket.entity.product.Product;
import com.geekbrains.geekmarket.mapper.product.ProductMapper;
import com.geekbrains.geekmarket.model.product.ProductDto;
import com.geekbrains.geekmarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(ProductDto dto) {
        return productRepository.save(productMapper.mapToEntity(dto));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
