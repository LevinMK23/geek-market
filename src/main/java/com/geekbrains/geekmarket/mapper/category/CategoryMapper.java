package com.geekbrains.geekmarket.mapper.category;

import com.geekbrains.geekmarket.entity.category.Category;
import com.geekbrains.geekmarket.model.category.CategoryDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoryMapper {

    CategoryDto map(Category source);

}
