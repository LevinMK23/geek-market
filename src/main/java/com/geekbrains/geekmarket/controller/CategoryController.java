package com.geekbrains.geekmarket.controller;

import com.geekbrains.geekmarket.aspect.BenchMark;
import com.geekbrains.geekmarket.mapper.category.CategoryMapper;
import com.geekbrains.geekmarket.model.category.CategoryDto;
import com.geekbrains.geekmarket.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryService.findAll()
                .stream()
                .map(categoryMapper::map)
                .collect(Collectors.toList());
    }

    @BenchMark
    @GetMapping("/{categoryId}")
    public CategoryDto getCategory(@PathVariable Long categoryId) {
        return categoryService.findById(categoryId)
                .map(categoryMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Category " + categoryId + " is not found"));
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryDto category) {
        return categoryMapper.map(categoryService.create(category));
    }
}
