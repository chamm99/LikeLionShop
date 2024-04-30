package com.likelion.likelionshop.controller;

import com.likelion.likelionshop.dto.request.CreateUserRequestDto;
import com.likelion.likelionshop.dto.request.UpdateUserRequestDto;
import com.likelion.likelionshop.dto.response.UserResponseDto;
import com.likelion.likelionshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    @PostMapping("")
    public UserResponseDto createUser(
            @RequestBody CreateUserRequestDto requestDto) {
        UserResponseDto userResponse = userService.createUser(requestDto);
        log.info(userResponse.getName());
        log.info(userResponse.getAddress());
        log.info(userResponse.getLoginId());
        return userResponse;
    }

    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping("/{userId}")
    public UserResponseDto getUser(
            @PathVariable Long userId) {
        UserResponseDto userResponse = userService.getUser(userId);
        log.info(String.valueOf(userResponse.getId()));
        return userResponse;
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    @PutMapping("/{userId}")
    public UserResponseDto updateUser(
            @RequestBody UpdateUserRequestDto requestDto,
            @RequestParam Long userId) {
        UserResponseDto userResponse = userService.updateUser(requestDto, userId);
        log.info(userResponse.getName());
        log.info(userResponse.getAddress());
        return userResponse;
    }

    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping("/{userId}")
    public String deleteUser(
            @PathVariable Long userId) {
        userService.deleteUser(userId);
        log.info(String.valueOf(userId));
        return "사용자 삭제";
    }

}