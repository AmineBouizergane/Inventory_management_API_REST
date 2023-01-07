package com.example.inventory_management.repository;

import com.example.inventory_management.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepos extends JpaRepository<Client, Integer> {
}
