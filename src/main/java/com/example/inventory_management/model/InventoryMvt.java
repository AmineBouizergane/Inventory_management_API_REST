package com.example.inventory_management.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class InventoryMvt extends AbstractEntity{
    private Instant mvtDate;
    private BigDecimal quantity;
    private Item item;
    private InventoryMvtType mvtType;
}
