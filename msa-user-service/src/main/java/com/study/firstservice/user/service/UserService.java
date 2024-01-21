package com.study.firstservice.user.service;

import com.study.firstservice.user.dto.request.CreateUser;
import com.study.firstservice.user.dto.response.UserResponse;

public interface UserService {

    UserResponse createUser(CreateUser createUser);
}
