package com.example.inventory_management.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Sales extends AbstractEntity{
    private String code;
    private Instant saleDate;
    private String comment;
    private Integer idCompany;
}
