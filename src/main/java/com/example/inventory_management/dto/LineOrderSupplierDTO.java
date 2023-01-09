package com.example.inventory_management.dto;

import com.example.inventory_management.model.InventoryMvt;
import com.example.inventory_management.model.LineOrderSupplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Builder
@Data
public class LineOrderSupplierDTO {
    private Integer id;
    private ItemDTO item;
    @JsonIgnore
    private OrderSupplierDTO orderSupplier;
    private BigDecimal qte;
    private BigDecimal unitePrice;

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

    public LineOrderSupplier toEntity(){
        if (this == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this, LineOrderSupplier.class);
        }
    }
}
