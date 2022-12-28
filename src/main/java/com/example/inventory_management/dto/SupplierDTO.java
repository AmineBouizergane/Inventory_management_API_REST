package com.example.inventory_management.dto;

import com.example.inventory_management.model.Sales;
import com.example.inventory_management.model.Supplier;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Builder
@Data
public class SupplierDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private String image;
    private String mail;
    private String tel;
    private List<OrderSupplierDTO> ordersSupplier;

    public SupplierDTO fromEntity(Supplier supplier){
        if (supplier == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(supplier, SupplierDTO.class);
        }
    }
}
