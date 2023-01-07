package com.example.inventory_management.repository;

import com.example.inventory_management.model.Supplier;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepos extends JpaRepository<Supplier, Integer> {
}
