package com.example.inventory_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class OrderSupplier extends AbstractEntity{
    private String code;
    private Instant orderDate;
    @ManyToOne
    @JoinColumn(name="idSupplier")
    private Supplier supplier;
    @OneToMany(mappedBy="orderSupplier")
    private List<LineOrderSupplier> linesOrderSupplier;
    private Integer idCompany;
}
