package com.example.inventory_management.service;

import com.example.inventory_management.dto.LineOrderClientDTO;
import com.example.inventory_management.dto.OrderClientDTO;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface OrderClientService {
    OrderClientDTO save(OrderClientDTO orderClientDTO);
    OrderClientDTO findById(Integer id);
    OrderClientDTO findByCode(String code);
    List<OrderClientDTO> findAll();
    void delete(Integer id);
}
