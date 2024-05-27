package com.likelion.likelionshop.global.common.status;

import com.likelion.likelionshop.global.common.code.BaseCode;
import com.likelion.likelionshop.global.common.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    _OK(HttpStatus.OK, "COMMON200", "성공입니다."),
    _CREATED(HttpStatus.CREATED, "COMMON201", "요청 성공 및 리소스 생성됨"),
    _NO_CONTENT(HttpStatus.NO_CONTENT, "COMMON204", "삭제되었습니다."),

    _FOLLOW_REQUEST(HttpStatus.OK, "COMMON210", "팔로우 요청 성공");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder().
                message(message).
                code(code).
                isSuccess(true).
                build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }

}
