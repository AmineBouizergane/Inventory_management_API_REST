package com.example.inventory_management.repository;

import com.example.inventory_management.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderClientRepos extends JpaRepository<OrderClient, Integer> {
    Optional<OrderClient> findByCode(String code);
}
