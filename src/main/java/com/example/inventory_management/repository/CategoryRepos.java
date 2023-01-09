package com.example.inventory_management.repository;

import com.example.inventory_management.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepos extends JpaRepository<Category, Integer> {
    Optional<Category> findByCode(String code);
}
