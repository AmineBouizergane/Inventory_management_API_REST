package com.example.inventory_management.repository;

import com.example.inventory_management.model.LineOrderSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineOrderSupplierRepos extends JpaRepository<LineOrderSupplier, Integer> {
}
