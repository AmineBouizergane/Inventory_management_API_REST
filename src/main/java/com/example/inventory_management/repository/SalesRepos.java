package com.example.inventory_management.repository;

import com.example.inventory_management.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepos extends JpaRepository<Sales, Integer> {
}
