package com.study.firstservice.user.dto.response;

import java.util.Date;

public record OrderResponse(
        String orderId,
        String productId,
        Integer quantity,
        Integer unitPrice,
        Integer totalPrice,
        Date createdAt
) {
}
