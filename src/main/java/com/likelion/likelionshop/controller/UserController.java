package com.likelion.likelionshop.controller;

import com.likelion.likelionshop.dto.request.CreateUserRequestDto;
import com.likelion.likelionshop.dto.request.UpdateUserRequestDto;
import com.likelion.likelionshop.dto.response.UserResponseDto;
import com.likelion.likelionshop.global.common.ApiResponse;
import com.likelion.likelionshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse<UserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        UserResponseDto responseDto = userService.createUser(createUserRequestDto);
        return ApiResponse.onSuccess(responseDto);
    }

    @GetMapping("")
    public ApiResponse<UserResponseDto> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("User Email ---> {}", userDetails.getUsername());
        return ApiResponse.onSuccess(userService.getUser(userDetails.getUsername()));
    }

    @PutMapping("")
    public ApiResponse<UserResponseDto> updateUser(@AuthenticationPrincipal UserDetails userDetails, @RequestBody UpdateUserRequestDto userUpdateRequestDto) {
        UserResponseDto responseDto = userService.updateUser(userDetails.getUsername(), userUpdateRequestDto);
        return ApiResponse.onSuccess(responseDto);
    }

    @DeleteMapping("")
    public ApiResponse<Void> deleteUser(@AuthenticationPrincipal UserDetails userDetails) {
        userService.deleteUser(userDetails.getUsername());
        return ApiResponse.noContent();
    }
}