package com.example.inventory_management.service;

import com.example.inventory_management.dto.ClientDTO;
import com.example.inventory_management.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO save(SupplierDTO supplierDTO);
    SupplierDTO findById(Integer id);
    List<SupplierDTO> findAll();
    void delete(Integer id);
}
