package com.likelion.likelionshop.Controller;

import com.likelion.likelionshop.Dto.CreateUserRequestDto;
import com.likelion.likelionshop.Dto.UpdateUserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/user")
public class UserController {

    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    @PostMapping("/post")
    public String createUser(
            @RequestBody CreateUserRequestDto requestDto) {
        log.info(requestDto.getName());
        log.info(requestDto.getAddress());
        log.info(requestDto.getId());
        log.info(requestDto.getPassword());
        return "사용자 생성";
    }

    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping("/{id}")
    public String getUser(
            @RequestBody CreateUserRequestDto requestDto,
            @PathVariable long id) {
        log.info(String.valueOf(id));
        return "사용자 조회";
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    @PutMapping("/update")
    public String updateUser(
            @RequestBody UpdateUserRequestDto requestDto) {
        log.info(requestDto.getName());
        log.info(requestDto.getAddress());
        return "사용자 수정";
    }

    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping("/{id}")
    public String deleteUser(
            @RequestBody CreateUserRequestDto requestDto,
            @PathVariable long id) {
        log.info(String.valueOf(id));
        return "사용자 삭제";
    }

}