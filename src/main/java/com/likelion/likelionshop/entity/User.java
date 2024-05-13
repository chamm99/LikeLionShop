package com.likelion.likelionshop.entity;

import com.likelion.likelionshop.dto.request.UpdateUserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "roles")
    private String roles;

    @Column
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    public void update(UpdateUserRequestDto updateUserRequestDto) {
        name = updateUserRequestDto.getName();
        address = updateUserRequestDto.getAddress();
        email = updateUserRequestDto.getEmail();
        password = updateUserRequestDto.getPassword();
    }
}
