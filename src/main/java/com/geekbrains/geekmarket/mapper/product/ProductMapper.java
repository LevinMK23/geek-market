package com.geekbrains.geekmarket.mapper.product;

import com.geekbrains.geekmarket.entity.category.Category;
import com.geekbrains.geekmarket.entity.product.Product;
import com.geekbrains.geekmarket.model.product.ProductDto;
import com.geekbrains.geekmarket.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CategoryService categoryService;

    public ProductDto mapToDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        if (product.getCategory() != null) {
            dto.setCategoryTitle(product.getCategory().getTitle());
        }
        return dto;
    }

    public Product mapToEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        if (dto.getCategoryTitle() != null) {
            categoryService.findByTitle(dto.getCategoryTitle())
                            .ifPresentOrElse(
                                    product::setCategory,
                                    () -> {
                                        Category newCategory = categoryService.create(dto.getCategoryTitle());
                                        product.setCategory(newCategory);
                                    }
                            );
        }
        return product;
    }

}
