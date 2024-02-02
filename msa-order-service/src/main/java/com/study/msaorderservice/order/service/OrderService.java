package com.study.msaorderservice.order.service;

import com.study.msaorderservice.order.domain.OrderEntity;
import com.study.msaorderservice.order.dto.request.OrderCreateRequest;
import com.study.msaorderservice.order.dto.response.OrderResponse;

public interface OrderService {

    OrderResponse createOrder(OrderCreateRequest orderCreateRequest);

    OrderResponse findOrderByOrderId(String orderId);

    Iterable<OrderEntity> findOrdersByUserId(String userId);
}
