package com.likelion.likelionshop.dto.response;

import com.likelion.likelionshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserResponseDto {

    private Long id;

    private String name;

    public String address;

    public String loginId;

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .address(user.getAddress())
                .loginId(user.getLoginId())
                .build();
    }
}
