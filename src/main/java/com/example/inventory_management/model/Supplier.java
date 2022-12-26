package com.example.inventory_management.model;

import jakarta.persistence.Embedded;
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
public class Supplier extends AbstractEntity{
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
    private String image;
    private String mail;
    private String tel;
    @OneToMany(mappedBy = "supplier")
    private List<OrderSupplier> ordersSupplier;
}
