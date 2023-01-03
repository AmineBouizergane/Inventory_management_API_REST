package com.example.inventory_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Roles extends AbstractEntity{

    private String roleName;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private Integer idCompany;
}
