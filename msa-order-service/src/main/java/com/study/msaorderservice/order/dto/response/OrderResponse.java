package com.study.msaorderservice.order.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.study.msaorderservice.order.domain.OrderEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record OrderResponse(

        String userId,
        String orderId,
        String productId,
        Integer quantity,
        Integer unitPrice,
        Integer totalPrice,
        LocalDateTime createdAt
) {

    public static OrderResponse from(OrderEntity orderEntity) {
        return OrderResponse.builder()
                .productId(orderEntity.productId())
                .quantity(orderEntity.quantity())
                .unitPrice(orderEntity.unitPrice())
                .totalPrice(orderEntity.totalPrice())
                .createdAt(orderEntity.getCreatedAt())
                .build();
    }
}
