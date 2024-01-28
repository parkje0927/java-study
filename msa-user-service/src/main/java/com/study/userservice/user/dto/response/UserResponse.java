package com.study.userservice.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.study.userservice.user.domain.UserEntity;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserResponse(
        Long id,
        String userId,
        List<OrderResponse> orders
) {

    public static UserResponse from(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.id())
                .userId(userEntity.userId())
                .build();
    }

    public static UserResponse of(UserEntity userEntity, List<OrderResponse> orderResponses) {
        return UserResponse.builder()
                .id(userEntity.id())
                .userId(userEntity.userId())
                .orders(orderResponses)
                .build();
    }
}
