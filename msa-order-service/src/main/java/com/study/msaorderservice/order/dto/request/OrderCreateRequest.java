package com.study.msaorderservice.order.dto.request;

public record OrderCreateRequest(
        String userId,
        String productId,
        Integer quantity,
        Integer unitPrice
) {
}
