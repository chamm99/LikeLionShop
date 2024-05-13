package com.likelion.likelionshop.dto.request;

import com.likelion.likelionshop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateUserRequestDto {

    public String name;

    public String email;

    public String password;

    public String address;

    //User Dto -> User Entity로 변환하는 메서드
    public User toEntity(PasswordEncoder passwordEncoder) {
        //Password Encoder 통해 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(password);
        return User.builder()
                .name(name)
                .email(email)
                .password(encodedPassword) //암호화된 비밀번호 저장
                .address(address)
                .roles("USER")
                .build();
    }
}