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
public class OrderClient extends AbstractEntity{
    private String code;
    private Instant OrderDate;
    @ManyToOne
    @JoinColumn(name="idClient")
    private Client client;
    @OneToMany(mappedBy="orderClient")
    private List<LineOrderClient> lineOrderClientList;
}
