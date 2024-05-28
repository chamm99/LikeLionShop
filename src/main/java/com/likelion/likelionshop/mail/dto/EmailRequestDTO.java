package com.likelion.likelionshop.mail.dto;

import lombok.Getter;

public class EmailRequestDTO {

    @Getter
    public static class EmailAuthRequest {
        private String email;
        private String certificationNum;
    }

    @Getter
    public static class EmailCheckRequest {
        private String email;
    }
}
