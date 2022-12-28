package com.example.inventory_management.dto;

import com.example.inventory_management.model.Category;
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
    private List<ItemDTO> items;

    public CategoryDTO fromEntity(Category category){
        if (category == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(category, CategoryDTO.class);
        }
    }
}
