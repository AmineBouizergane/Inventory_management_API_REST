package com.example.inventory_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.Order;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LineOrderClient extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="articleId")
    private Item item;
    @ManyToOne
    @JoinColumn(name="orderClientId")
    private OrderClient orderClient;
}
