package com.likelion.likelionshop.entity;

import com.likelion.likelionshop.dto.request.UpdateUserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    public void update(UpdateUserRequestDto updateUserRequestDto) {
        name = updateUserRequestDto.getName();
        address = updateUserRequestDto.getAddress();
        loginId = updateUserRequestDto.getLoginId();
        password = updateUserRequestDto.getPassword();
    }
}
