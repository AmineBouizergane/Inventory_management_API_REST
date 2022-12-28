package com.example.inventory_management.dto;

import com.example.inventory_management.model.Company;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@Builder
public class CompanyDTO {
    private Integer id;
    private String name;
    private String description;
    private AddressDTO address;
    private String taxCode;
    private String image;
    private String mail;
    private String tel;
    private List<UserDTO> users;
    public CompanyDTO fromEntity(Company company){
        if (company == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(company, CompanyDTO.class);
        }
    }
}
