package com.example.inventory_management.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends AbstractEntity{
    private String firstName;
    private String lastName;
    private Instant birthday;
    private String password;
    @Embedded
    private Address address;
    private String image;
    private String mail;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;
    @OneToMany(mappedBy = "user")
    private List<Roles> roles;
}
