package com.study.firstservice.user.service;

import com.study.firstservice.user.domain.UserEntity;
import com.study.firstservice.user.domain.UserRepository;
import com.study.firstservice.user.dto.request.CreateUser;
import com.study.firstservice.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        return new UserResponse(userEntity.id(), userEntity.userId());
    }
}
