package com.example.inventory_management.service.impl;

import com.example.inventory_management.dto.CategoryDTO;
import com.example.inventory_management.exceptions.EntityNotFoundException;
import com.example.inventory_management.exceptions.ErrorCodes;
import com.example.inventory_management.exceptions.InvalidEntityException;
import com.example.inventory_management.model.Category;
import com.example.inventory_management.repository.CategoryRepos;
import com.example.inventory_management.service.CategoryService;
import com.example.inventory_management.utils.ErrorMsgConstant;
import com.example.inventory_management.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepos categoryRepos;

    public CategoryServiceImpl(CategoryRepos categoryRepos){
        this.categoryRepos= categoryRepos;
    }
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        List<String> errors = CategoryValidator.validate(categoryDTO);
        if(!errors.isEmpty())
        {
            log.error("Invalid Category", categoryDTO);
            throw new InvalidEntityException(ErrorMsgConstant.INVALID_CATEGORY, ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDTO.fromEntity(
                categoryRepos.save(CategoryDTO.toEntity(categoryDTO))
        );
    }

    @Override
    public CategoryDTO findById(Integer id) {
        if(id == null){
            log.error("Category ID is null");
            return null;
        }

        Optional<Category> category = categoryRepos.findById(id);
        CategoryDTO categoryDTO = CategoryDTO.fromEntity(category.get());
        return Optional.of(categoryDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_CATEGORY, ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategoryDTO findByCode(String code) {
        if(code == null){
            log.error("Category ID is null");
            return null;
        }

        Optional<Category> category = categoryRepos.findByCode(code);
        CategoryDTO categoryDTO = CategoryDTO.fromEntity(category.get());
        return Optional.of(categoryDTO).orElseThrow(() ->
                new EntityNotFoundException(ErrorMsgConstant.UNAVAILABLE_CATEGORY, ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepos.findAll().stream()
                .map(CategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Category ID is null");
            return;
        }
        categoryRepos.deleteById(id);
    }
}
