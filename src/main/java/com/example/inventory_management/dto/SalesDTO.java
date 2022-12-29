package com.example.inventory_management.dto;

import com.example.inventory_management.model.InventoryMvt;
import com.example.inventory_management.model.Roles;
import com.example.inventory_management.model.Sales;
import com.example.inventory_management.model.Supplier;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.Instant;

@Builder
@Data
public class SalesDTO {
    private Integer id;
    private String code;
    private Instant saleDate;
    private String comment;

    public SalesDTO fromEntity(Sales sales){
        if (sales == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(sales, SalesDTO.class);
        }
    }

    public Sales toEntity(){
        if (this == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this, Sales.class);
        }
    }
}
