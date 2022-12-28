package com.example.inventory_management.dto;

import com.example.inventory_management.model.Supplier;
import com.example.inventory_management.model.User;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Instant birthday;
    private String password;
    private AddressDTO address;
    private String image;
    private String mail;
    private CompanyDTO company;
    private List<RolesDTO> roles;

    public UserDTO fromEntity(User user){
        if (user == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(user, UserDTO.class);
        }
    }
}
