package com.study.catalogservice.catalog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "catalog")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CatalogEntity extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer unitPrice;

    public String productId() {
        return productId;
    }

    public String productName() {
        return productName;
    }

    public Integer stock() {
        return stock;
    }

    public Integer unitPrice() {
        return unitPrice;
    }
}
