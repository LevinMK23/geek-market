package com.geekbrains.geekmarket.mapper.product;

import com.geekbrains.geekmarket.entity.product.Product;
import com.geekbrains.geekmarket.model.product.ProductDto;
import org.hibernate.annotations.Source;
import org.mapstruct.*;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapstructMapper {

    @Mappings(value = {
            @Mapping(target = "categoryTitle", source = "category.title")
    })
    ProductDto mapToDto(Product product);

//    @AfterMapping
//    default void mapCategory(Product product, @MappingTarget ProductDto dto) {
//        if (product.getCategory() != null) {
//            dto.setCategoryTitle(product.getCategory().getTitle());
//        }
//    }

}
