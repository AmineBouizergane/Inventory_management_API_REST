package com.example.inventory_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LineSale extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "saleId")
    private Sales sales;
    private BigDecimal quantity;
    private Integer idCompany;

}
