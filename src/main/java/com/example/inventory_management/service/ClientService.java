package com.example.inventory_management.service;

import com.example.inventory_management.dto.ClientDTO;
import com.example.inventory_management.dto.ItemDTO;

import java.util.List;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO);
    ClientDTO findById(Integer id);
    List<ClientDTO> findAll();
    void delete(Integer id);
}
