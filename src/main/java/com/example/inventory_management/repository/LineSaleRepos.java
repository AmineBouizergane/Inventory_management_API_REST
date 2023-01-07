package com.example.inventory_management.repository;

import com.example.inventory_management.model.LineSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineSaleRepos extends JpaRepository<LineSale, Integer> {
}
