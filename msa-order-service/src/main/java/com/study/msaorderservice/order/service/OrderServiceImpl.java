package com.study.msaorderservice.order.service;

import com.study.msaorderservice.order.domain.OrderEntity;
import com.study.msaorderservice.order.domain.OrderRepository;
import com.study.msaorderservice.order.dto.request.OrderCreateRequest;
import com.study.msaorderservice.order.dto.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public OrderResponse createOrder(final OrderCreateRequest orderCreateRequest) {
        OrderEntity orderEntity = OrderEntity.builder()
                .userId(orderCreateRequest.userId())
                .orderId(UUID.randomUUID().toString())
                .productId(orderCreateRequest.productId())
                .quantity(orderCreateRequest.quantity())
                .unitPrice(orderCreateRequest.unitPrice())
                .totalPrice(orderCreateRequest.quantity() * orderCreateRequest.unitPrice())
                .build();

        orderRepository.save(orderEntity);
        return OrderResponse.from(orderEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public OrderResponse findOrderByOrderId(final String orderId) {
        OrderEntity orderEntity = orderRepository.findByOrderId(orderId);
        return OrderResponse.from(orderEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<OrderEntity> findOrdersByUserId(final String userId) {
        return orderRepository.findAll();
    }
}
