package com.example.inventory_management.service;

import com.example.inventory_management.dto.ClientDTO;
import com.example.inventory_management.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO save(CompanyDTO companyDTO);
    CompanyDTO findById(Integer id);
    List<CompanyDTO> findAll();
    void delete(Integer id);
}
