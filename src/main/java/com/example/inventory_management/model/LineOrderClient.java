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
public class LineOrderClient extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="itemId")
    private Item item;
    @ManyToOne
    @JoinColumn(name="orderClientId")
    private OrderClient orderClient;
    private BigDecimal qte;
    private BigDecimal unitePrice;
    private Integer idCompany;
}
