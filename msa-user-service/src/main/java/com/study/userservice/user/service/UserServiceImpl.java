package com.study.userservice.user.service;

import com.study.userservice.user.domain.UserEntity;
import com.study.userservice.user.domain.UserRepository;
import com.study.userservice.user.dto.request.CreateUser;
import com.study.userservice.user.dto.response.OrderResponse;
import com.study.userservice.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(final CreateUser createUser) {
        UserEntity userEntity = createUser.fromUUID(UUID.randomUUID().toString());
        userEntity.updatePassword(passwordEncoder.encode(createUser.password()));
        userRepository.save(userEntity);
        return UserResponse.from(userEntity);
    }

    @Override
    public UserResponse getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        //TODO 아직 Order 구현 X
        List<OrderResponse> orderResponses = new ArrayList<>();
        return UserResponse.of(userEntity, orderResponses);
    }

    @Override
    public List<UserResponse> getUserByAll() {
        Iterable<UserEntity> users = findUsers();
        List<UserResponse> userResponses = new ArrayList<>();
        users.forEach(userEntity -> userResponses.add(UserResponse.from(userEntity)));
        return userResponses;
    }

    private Iterable<UserEntity> findUsers() {
        return userRepository.findAll();
    }
}
