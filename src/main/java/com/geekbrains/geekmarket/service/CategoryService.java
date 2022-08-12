package com.geekbrains.geekmarket.service;

import com.geekbrains.geekmarket.entity.category.Category;
import com.geekbrains.geekmarket.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public Category create(String title) {
        Category category = new Category();
        category.setTitle(title);
        return categoryRepository.save(category);
    }

}
