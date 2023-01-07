package com.example.inventory_management.repository;

import com.example.inventory_management.model.InventoryMvt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMvtRepos extends JpaRepository<InventoryMvt, Integer> {
}
