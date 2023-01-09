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
public class LineOrderSupplier extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name="articleId")
    private Item item;
    @ManyToOne
    @JoinColumn(name="orderSupplierId")
    private OrderSupplier orderSupplier;
    private BigDecimal qte;
    private BigDecimal unitePrice;
    private Integer idCompany;
}
