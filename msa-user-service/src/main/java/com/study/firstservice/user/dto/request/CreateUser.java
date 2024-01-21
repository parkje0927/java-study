package com.study.firstservice.user.dto.request;

import com.study.firstservice.user.domain.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateUser(
        @NotBlank(message = "email cannot be null")
        @Size(min = 2, message = "email cannot be less than two characters")
        String email,

        @NotBlank(message = "name cannot be null")
        @Size(min = 2, message = "name cannot be less than two characters")
        String name,

        @NotBlank(message = "password cannot be null")
        @Size(min = 8, message = "password must be equal or greater than eight characters")
        String password
) {

    public UserEntity fromUUID(String UUID) {
        return UserEntity.builder()
                .email(email)
                .name(name)
                .userId(UUID)
                .build();
    }
}
