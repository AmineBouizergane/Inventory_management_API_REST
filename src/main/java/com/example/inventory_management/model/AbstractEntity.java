package com.example.inventory_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@CreatedDate
    @JsonIgnore
    private Instant createdDate;

    //@LastModifiedDate
    @JsonIgnore
    private Instant lastModifiedDate;
}
