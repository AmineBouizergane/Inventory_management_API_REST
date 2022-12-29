package com.example.inventory_management.validator;

import com.example.inventory_management.dto.CategoryDTO;
import com.example.inventory_management.utils.ValidatorConstant;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDTO categoryDTO){
        List<String> errors = new ArrayList<>();

        if(categoryDTO == null || !StringUtils.hasLength(categoryDTO.getCode())){
            errors.add(ValidatorConstant.REQUIRED_CATEGORY_CODE);
        }

        return errors;
    }
}
