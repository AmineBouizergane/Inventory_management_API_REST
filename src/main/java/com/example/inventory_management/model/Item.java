package com.example.inventory_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Item extends AbstractEntity{

    private String codeItem;
    private String designation;
    private BigDecimal unitPriceHT;
    private BigDecimal tva;
    private BigDecimal unitPriceTTC;
    private String image;
    private Integer idCompany;
    @ManyToOne
    private Category category;
}
