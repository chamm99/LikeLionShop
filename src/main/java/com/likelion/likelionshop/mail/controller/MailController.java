package com.likelion.likelionshop.mail.controller;

import com.likelion.likelionshop.global.common.ApiResponse;
import com.likelion.likelionshop.mail.dto.EmailRequestDTO;
import com.likelion.likelionshop.mail.service.EmailService;
import com.likelion.likelionshop.utils.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/id")
@RequiredArgsConstructor
public class MailController {

    private final EmailService emailService;
    private final RedisUtil redisUtil;

    // 인증번호 전송
    @PostMapping("/mail/check")
    public ApiResponse<Object> emailConfirm(@RequestBody EmailRequestDTO.EmailCheckRequest emailCheckRequest) throws Exception {
        String confirm = emailService.sendSimpleMessage(emailCheckRequest.getEmail());
        if (confirm.isEmpty()) {
            return ApiResponse.onFailure("인증번호 전송 실패");
        } else {
            return ApiResponse.onSuccess("인증번호 전송 성공");
        }
    }

    // 인증번호 확인
    @PostMapping("/mail/authentication")
    public ApiResponse<Object> emailAuthentication(@RequestBody EmailRequestDTO.EmailAuthRequest emailAuthRequest) {
        String email = emailAuthRequest.getEmail();
        String certificationNum = emailAuthRequest.getCertificationNum();

        // Redis에서 인증 번호 조회
        String storedCertificationNum = (String) redisUtil.get(email);

        if (storedCertificationNum != null && storedCertificationNum.equals(certificationNum)) {
            return ApiResponse.onSuccess("인증번호가 일치합니다.");
        } else {
            return ApiResponse.onFailure("인증번호가 일치하지 않습니다.");
        }
    }
}
