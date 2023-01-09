package com.example.inventory_management.dto;

import com.example.inventory_management.model.Address;
import com.example.inventory_management.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Builder
@Data
public class CategoryDTO {
    private Integer id;
    private String code;
    private String designation;

    @JsonIgnore
    private List<ItemDTO> items;

    public static CategoryDTO fromEntity(Category category){
        if (category == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(category, CategoryDTO.class);
        }
    }

    public static Category toEntity(CategoryDTO categoryDTO){
        if (categoryDTO == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(categoryDTO, Category.class);
        }
    }
}
