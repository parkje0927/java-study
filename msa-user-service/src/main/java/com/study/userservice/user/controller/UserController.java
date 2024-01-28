package com.study.userservice.user.controller;

import com.study.userservice.user.dto.request.CreateUser;
import com.study.userservice.user.dto.response.UserResponse;
import com.study.userservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody final CreateUser createUser) {
        UserResponse userResponse = userService.createUser(createUser);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> userResponses = userService.getUserByAll();
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId) {
        UserResponse userResponse = userService.getUserByUserId(userId);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
