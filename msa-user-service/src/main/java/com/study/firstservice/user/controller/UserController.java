package com.study.firstservice.user.controller;

import com.study.firstservice.user.dto.request.CreateUser;
import com.study.firstservice.user.dto.response.UserResponse;
import com.study.firstservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody final CreateUser createUser) {
        UserResponse userResponse = userService.createUser(createUser);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}
