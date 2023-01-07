package com.example.inventory_management.repository;

import com.example.inventory_management.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepos extends JpaRepository<Item, Integer> {
    Optional<Item> findByCodeItem(String code);
}
