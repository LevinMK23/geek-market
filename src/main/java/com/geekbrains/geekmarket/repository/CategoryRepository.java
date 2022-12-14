package com.geekbrains.geekmarket.repository;

import com.geekbrains.geekmarket.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByTitle(String title);

}
