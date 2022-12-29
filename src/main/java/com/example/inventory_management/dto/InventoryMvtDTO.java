package com.example.inventory_management.dto;

import com.example.inventory_management.model.Address;
import com.example.inventory_management.model.InventoryMvt;
import com.example.inventory_management.model.InventoryMvtType;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class InventoryMvtDTO {
    private Integer id;
    private Instant mvtDate;
    private BigDecimal quantity;
    private ItemDTO item;
    private InventoryMvtType mvtType;

    public InventoryMvtDTO fromEntity(InventoryMvt inventoryMvt){
        if (inventoryMvt == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(inventoryMvt, InventoryMvtDTO.class);
        }
    }

    public InventoryMvt toEntity(){
        if (this == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this, InventoryMvt.class);
        }
    }
}
