package com.example.inventory_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbstractEntity{
    private String code;
    private String designation;
    @OneToMany(mappedBy = "category")
    private List<Item> items;
}
