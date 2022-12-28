package com.example.inventory_management.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    private String address1;
    private String address2;
    private String city;
    private String zipCode;
    private String country;

}
