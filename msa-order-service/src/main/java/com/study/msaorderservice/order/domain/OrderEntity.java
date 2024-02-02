package com.study.msaorderservice.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, unique = true)
    private String orderId;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false)
    private Integer totalPrice;

    @Builder
    public OrderEntity(Long id, String userId, String orderId, String productId, Integer quantity,
                       Integer unitPrice, Integer totalPrice) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String productId() {
        return productId;
    }

    public Integer quantity() {
        return quantity;
    }

    public Integer unitPrice() {
        return unitPrice;
    }

    public Integer totalPrice() {
        return totalPrice;
    }

    public String userId() {
        return userId;
    }

    public String orderId() {
        return orderId;
    }
}
