package com.example.inventory_management.dto;

import com.example.inventory_management.model.InventoryMvt;
import com.example.inventory_management.model.OrderClient;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class OrderClientDTO {
    private Integer id;
    private String code;
    private Instant OrderDate;
    private ClientDTO client;
    private List<LineOrderClientDTO> lineOrderClientList;

    public OrderClientDTO fromEntity(OrderClient oc){
        if (oc == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(oc, OrderClientDTO.class);
        }
    }

    public OrderClient toEntity(){
        if (this == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this, OrderClient.class);
        }
    }
}
