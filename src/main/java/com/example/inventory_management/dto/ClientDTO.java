package com.example.inventory_management.dto;

import com.example.inventory_management.model.Address;
import com.example.inventory_management.model.Client;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@Builder
public class ClientDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private String image;
    private String mail;
    private String tel;
    private List<OrderClientDTO> ordersClient;

    public static ClientDTO fromEntity(Client client){
        if (client == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(client, ClientDTO.class);
        }
    }

    public static Client toEntity(ClientDTO clientDTO){
        if (clientDTO == null){
            // TODO: Exception
            return null;
        }else
        {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(clientDTO, Client.class);
        }
    }
}
