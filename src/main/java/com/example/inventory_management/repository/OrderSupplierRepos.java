package com.example.inventory_management.repository;

import com.example.inventory_management.model.Item;
import com.example.inventory_management.model.OrderSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSupplierRepos extends JpaRepository<OrderSupplier, Integer> {
}
