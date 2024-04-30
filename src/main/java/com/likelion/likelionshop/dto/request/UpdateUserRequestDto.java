package com.likelion.likelionshop.dto.request;

import com.likelion.likelionshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateUserRequestDto {

    public Long id;

    public String name;

    public String address;

    public User toEntity() {
        return User.builder()
                .name(name)
                .address(address)
                .build();
    }
}