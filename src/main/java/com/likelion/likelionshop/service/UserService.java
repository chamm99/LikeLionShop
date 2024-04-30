package com.likelion.likelionshop.service;

import com.likelion.likelionshop.dto.request.CreateUserRequestDto;
import com.likelion.likelionshop.dto.request.UpdateUserRequestDto;
import com.likelion.likelionshop.dto.response.UserResponseDto;
import com.likelion.likelionshop.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
//    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(CreateUserRequestDto request) {
        User user = request.toEntity();
//        userRepository.save(user);
        return UserResponseDto.from(user);
    }

    @Transactional
    public UserResponseDto updateUser(UpdateUserRequestDto request, Long id) {
        User user = request.toEntity();
        user.update(request);
        //userRepository.save(user);
        return UserResponseDto.from(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long id) {
        User user = null;
        //user = userRepository.findById(id);
        return UserResponseDto.from(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        //userRepository.deleteById(id);
    }
}
