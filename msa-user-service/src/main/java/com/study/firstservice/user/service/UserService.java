package com.study.firstservice.user.service;

import com.study.firstservice.user.dto.request.CreateUser;
import com.study.firstservice.user.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUser createUser);

    UserResponse getUserByUserId(String userId);

    List<UserResponse> getUserByAll();
}
