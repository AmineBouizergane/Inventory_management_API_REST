package com.example.inventory_management.dto;

import com.example.inventory_management.model.InventoryMvt;
import com.example.inventory_management.model.Item;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Builder
@Data
public class ItemDTO {
    private Integer id;
    private String codeItem;
    private String designation;
    private BigDecimal unitPriceHT;
    private BigDecimal tva;
    private BigDecimal unitPriceTTC;
    private String image;
    private CategoryDTO category;

    public ItemDTO fromEntity(Item item){
        if (item == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(item, ItemDTO.class);
        }
    }

    public Item toEntity(){
        if (this == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(this, Item.class);
        }
    }
}
