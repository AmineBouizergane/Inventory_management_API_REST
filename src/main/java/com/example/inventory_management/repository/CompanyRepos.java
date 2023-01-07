package com.example.inventory_management.repository;

import com.example.inventory_management.model.Client;
import com.example.inventory_management.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepos extends JpaRepository<Company, Integer> {
}
