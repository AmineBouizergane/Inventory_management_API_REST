package com.example.inventory_management.dto;

import com.example.inventory_management.model.InventoryMvt;
import com.example.inventory_management.model.LineOrderClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Builder
@Data
public class LineOrderClientDTO {
    private Integer id;
    private ItemDTO item;
    @JsonIgnore
    private OrderClientDTO orderClient;
    private BigDecimal qte;
    private BigDecimal unitePrice;

    public static LineOrderClientDTO fromEntity(LineOrderClient loc){
        if (loc == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(loc, LineOrderClientDTO.class);
        }
    }

    public static LineOrderClient toEntity(LineOrderClientDTO lineOrderClientDTO){
        if (lineOrderClientDTO == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(lineOrderClientDTO, LineOrderClient.class);
        }
    }
}
