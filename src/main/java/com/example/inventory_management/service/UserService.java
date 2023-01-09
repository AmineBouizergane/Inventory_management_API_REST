package com.example.inventory_management.service;

import com.example.inventory_management.dto.SupplierDTO;
import com.example.inventory_management.dto.UserDTO;
import com.example.inventory_management.model.User;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    UserDTO findById(Integer id);
    List<UserDTO> findAll();
    void delete(Integer id);
}
