package com.likelion.likelionshop.global.common.status;

import com.likelion.likelionshop.global.common.code.BaseErrorCode;
import com.likelion.likelionshop.global.common.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 기본 에러
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // Course 에러
    _NOT_FOUND_PREVIOUS_LECTURE(HttpStatus.NOT_FOUND, "COURSE400", "요청한 정보에 해당하는 강의가 존재하지 않습니다."),
    _NOT_FOUND_PREVIOUS_LECTURE_BY_SEMESTER_YEAR(HttpStatus.NOT_FOUND, "COURSE400", "요청한 년도학기에 해당하는 강의가 존재하지 않습니다."),
    _NOT_FOUND_COURSE(HttpStatus.NOT_FOUND, "COURSE400", "강의가 사용자 강의 목록에 존재하지 않습니다."),

    // User 에러
    _NOT_FOUND_USER(HttpStatus.NOT_FOUND, "USER400", "사용자가 존재하지 않습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder().message(message).code(code).isSuccess(false).build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }

}
