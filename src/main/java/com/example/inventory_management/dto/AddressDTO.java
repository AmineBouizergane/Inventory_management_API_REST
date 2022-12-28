package com.example.inventory_management.dto;

import com.example.inventory_management.model.Address;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
@Builder
public class AddressDTO {
    private String address1;
    private String address2;
    private String city;
    private String zipCode;
    private String country;

    public AddressDTO fromEntity(Address address){
        if (address == null){
            // TODO: Exception
            return null;
        }else
        {
            /*return AddressDTO.builder()
                    .address1(address.getAddress1())
                    .address2(address.getAddress2())
                    .city(address.getCity())
                    .zipCode(address.getZipCode())
                    .country(address.getCountry())
                    .build();*/
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(address, AddressDTO.class);
        }
    }
}
