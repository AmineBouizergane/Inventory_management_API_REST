package com.example.inventory_management.service;

import com.example.inventory_management.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO save(ItemDTO itemDTO);
    ItemDTO findById(Integer id);
    ItemDTO findByCodeItem(String codeItem);
    List<ItemDTO> findAll();
    void delete(Integer id);
}
