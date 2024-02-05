package com.study.userservice.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "email cannot be null")
        @Size(min = 2) String email,
        @NotBlank(message = "password cannot be null")
        @Size(min = 8) String password
) {
}
