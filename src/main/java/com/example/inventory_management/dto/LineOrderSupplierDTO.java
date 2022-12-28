package com.example.inventory_management.dto;

import com.example.inventory_management.model.LineOrderSupplier;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Builder
@Data
public class LineOrderSupplierDTO {
    private Integer id;
    private ItemDTO item;
    private OrderSupplierDTO orderSupplier;

    public LineOrderSupplierDTO fromEntity(LineOrderSupplier los){
        if (los == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(los, LineOrderSupplierDTO.class);
        }
    }
}
