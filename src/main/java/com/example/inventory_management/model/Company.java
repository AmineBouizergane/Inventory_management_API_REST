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
public class Company extends AbstractEntity{
    private String name;
    private String description;
    @Embedded
    private Address address;
    private String taxCode;
    private String image;
    private String mail;
    private String tel;
    @OneToMany(mappedBy = "company")
    private List<User> users;
}
