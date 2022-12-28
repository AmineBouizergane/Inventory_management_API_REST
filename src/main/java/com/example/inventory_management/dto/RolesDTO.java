package com.example.inventory_management.dto;

import com.example.inventory_management.model.OrderSupplier;
import com.example.inventory_management.model.Roles;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Builder
@Data
public class RolesDTO {
    private Integer id;
    private String roleName;
    private UserDTO user;

    public RolesDTO fromEntity(Roles roles){
        if (roles == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(roles, RolesDTO.class);
        }
    }
}
