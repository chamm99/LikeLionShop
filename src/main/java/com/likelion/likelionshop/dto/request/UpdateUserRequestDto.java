package com.likelion.likelionshop.dto.request;

import com.likelion.likelionshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequestDto {

    public String name;

    public String address;

    public String loginId;

    public String password;

    public User toEntity() {
        return User.builder()
                .name(name)
                .address(address)
                .loginId(loginId)
                .password(password)
                .build();
    }
}