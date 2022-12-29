package com.example.inventory_management.dto;

import com.example.inventory_management.model.InventoryMvt;
import com.example.inventory_management.model.OrderSupplier;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Builder
@Data
public class OrderSupplierDTO {
    private Integer id;
    private ItemDTO item;
    private OrderSupplierDTO orderSupplier;

    public OrderSupplierDTO fromEntity(OrderSupplier op){
        if (op == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(op, OrderSupplierDTO.class);
        }
    }

    public OrderSupplier toEntity(){
        if (this == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this, OrderSupplier.class);
        }
    }
}
