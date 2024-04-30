package com.likelion.likelionshop.dto.request;

import com.likelion.likelionshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateUserRequestDto {

    public String name;

    public String loginId;

    public String password;

    public String address;

    public User toEntity() {
        return User.builder()
                .name(name)
                .loginId(loginId)
                .password(password)
                .address(address)
                .build();
    }
}