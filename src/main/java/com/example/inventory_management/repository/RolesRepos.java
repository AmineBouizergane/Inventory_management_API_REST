package com.example.inventory_management.repository;

import com.example.inventory_management.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepos extends JpaRepository<Roles, Integer> {
}
