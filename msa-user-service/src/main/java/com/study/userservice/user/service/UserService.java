package com.study.userservice.user.service;

import com.study.userservice.user.dto.request.CreateUser;
import com.study.userservice.user.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUser createUser);

    UserResponse getUserByUserId(String userId);

    List<UserResponse> getUserByAll();
}
