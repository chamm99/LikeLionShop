package com.likelion.likelionshop.service;

import com.likelion.likelionshop.dto.request.CreateUserRequestDto;
import com.likelion.likelionshop.dto.request.UpdateUserRequestDto;
import com.likelion.likelionshop.entity.User;
import com.likelion.likelionshop.dto.response.UserResponseDto;
import com.likelion.likelionshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        User user = createUserRequestDto.toEntity(passwordEncoder);
        userRepository.save(user);
        return UserResponseDto.from(user);
    }
    public UserResponseDto getUser(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("사용자가 존재히지 않습니다."));
        return UserResponseDto.from(user);
    }
    @Transactional
    public UserResponseDto updateUser(String email, UpdateUserRequestDto userRequestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        user.update(userRequestDto);
        userRepository.save(user);
        return UserResponseDto.from(user);

    }
    @Transactional
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }
}