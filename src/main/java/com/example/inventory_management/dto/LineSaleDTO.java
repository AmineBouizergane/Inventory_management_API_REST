package com.example.inventory_management.dto;

import com.example.inventory_management.model.LineSale;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Builder
@Data
public class LineSaleDTO {
    private Integer id;
    private SalesDTO sales;
    private BigDecimal quantity;

    public LineSaleDTO fromEntity(LineSale ls){
        if (ls == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(ls, LineSaleDTO.class);
        }
    }
}
