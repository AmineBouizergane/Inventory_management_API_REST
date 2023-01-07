package com.example.inventory_management.repository;

import com.example.inventory_management.model.LineOrderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineOrderClientRepos extends JpaRepository<LineOrderClient, Integer> {
}
