package com.microservices.bootcamp.rds.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "services")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id", nullable = false, unique = true)
    private Long serviceId;

    @EqualsAndHashCode.Include
    @Column(name = "code", nullable = false, unique = true, length = 3)
    private String code;

    @Column(name = "code", nullable = false, length = 100)
    private String name;

    @Column(name = "unit", nullable = false, length = 3)
    private String unit;

    @Column(name = "price", precision = 2)
    private String price;

    @Column(name = "vat", precision = 2)
    private BigDecimal vat;
}
