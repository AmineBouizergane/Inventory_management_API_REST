package com.example.inventory_management.service;

import com.example.inventory_management.dto.CategoryDTO;
import com.example.inventory_management.dto.ItemDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO findById(Integer id);
    CategoryDTO findByCode(String code);
    List<CategoryDTO> findAll();
    void delete(Integer id);
}
